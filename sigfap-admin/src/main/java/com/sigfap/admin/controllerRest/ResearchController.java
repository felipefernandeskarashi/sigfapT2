package com.sigfap.admin.controllerRest;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.exception.JDBCConnectionException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.sigfap.admin.model.dao.AddressDAO;
import com.sigfap.admin.model.dao.EthnicityDAO;
import com.sigfap.admin.model.dao.ResearchDAO;
import com.sigfap.admin.model.dao.SkillDAO;
import com.sigfap.admin.model.dao.TelephoneDAO;
import com.sigfap.admin.model.entity.Address;
import com.sigfap.admin.model.entity.Research;
import com.sigfap.admin.model.entity.Telephone;
import com.sigfap.admin.security.intercept.annotation.Public;
import com.sigfap.admin.validation.CheckCpf;

@Controller
public class ResearchController {

	private final Result result1;

	private CheckCpf verificador;

	@Inject
	private ResearchDAO dao;

	@Inject
	private AddressDAO dao1;

	@Inject
	private EthnicityDAO dao2;

	@Inject
	private SkillDAO dao3;

	@Inject
	private TelephoneDAO dao4;

	/**
	 * @deprecated CDI eyes only
	 */
	protected ResearchController() {
		this(null, null);
	}

	@Inject
	public ResearchController(Result result1, ResearchDAO dao) {
		this.result1 = result1;
		this.dao = dao;
	}

	/** V1 - Versão 1 **/

	@Public
	@Get("/v1/researches")
	public void listarPesquisador() {
		List<Research> researches = dao.findAll();

		if (!researches.isEmpty()) {
			com.sigfap.admin.json.research.Result result = new com.sigfap.admin.json.research.Result();
			result.setValue(researches);

			result1.use(Results.json()).from(result).include("value")
					.include("value.enderecoRes").include("value.enderecoCom")
					.include("value.etniaPes").include("value.area")
					.include("value.telefones")
					.exclude("value.pesquisadorUnidades").serialize();
			result1.include("pesquisadores", result);
		} else {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Nenhum pesquisador cadastrado.");
			result1.use(Results.json()).from(error)
					.exclude("value.pesquisadorUnidades").recursive()
					.serialize();
			result1.include("pesquisadores", error);
		}
	}

	@Public
	@Post("/v1/researcher")
	public void inserirPesquisador(Research research, Address address,
			Address address2, Integer etniaId, Integer areaId,
			Telephone telephone) {

		if ((research.getEmail() == null) || (research.getSenha() == null)) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Preencher as informações de login.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else if ((research.getNome() == null) || (research.getCpf() == null)
				|| (research.getRg() == null)
				|| (research.getRgEmissor() == null)
				|| (research.getRgDataEmissor() == null)
				|| (research.getMae() == null) || (research.getPai() == null)
				|| (research.getNascimento() == null)
				|| (research.getSexo() == null)) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Preencher as informações de dados cadastrais.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else if ((research.getEscolaridade() == null)
				|| (research.getModalidadeBolsa() == null)
				|| (research.getObjConcessao() == null)) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Preencher as informações de dados escolares.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else if ((etniaId == null) || (areaId == null)
				|| (telephone.getNumero() == null)) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Preencher as informações adicionais de etnia, área de conhecimento ou telefone.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else if ((address.getRua() == null) || (address.getNumero() == null)
				|| (address.getBairro() == null)
				|| (address.getCepZip() == null) || (address2.getRua() == null)
				|| (address2.getNumero() == null)
				|| (address2.getBairro() == null)
				|| (address2.getCepZip() == null)) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Preencher as informações de endereços.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else if (verificador.verificaCpf(research.getCpf()) == false) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"CPF inválido.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else {
			try {
				dao1.persist(address);
				dao1.persist(address2);

				com.sigfap.admin.json.address.Result resultAddress = new com.sigfap.admin.json.address.Result();

				resultAddress.getValue().add(address);
				resultAddress.getValue().add(address2);

			} catch (JDBCConnectionException e) {

				com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
						"Problema de conexão com o banco.");
				result1.use(Results.json()).from(error).recursive().serialize();

			} catch (Exception e) {
				com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
						"Impossível cadastrar endereço de pesquisador.");
				result1.use(Results.json()).from(error).serialize();
				result1.include(error);
			}

			research.setEnderecoRes(address);
			research.setEnderecoCom(address2);

			research.setEtniaPes(dao2.findById(etniaId));
			research.setArea(dao3.findById(areaId));

			try {
				research.setSenha(DigestUtils.shaHex(research.getSenha()));
				research.setAtivo(true);
				dao.persist(research);

				telephone.setPesquisador(research);
				dao4.persist(telephone);

				com.sigfap.admin.json.telephone.Result resultTelephone = new com.sigfap.admin.json.telephone.Result();

				resultTelephone.getValue().add(telephone);

				com.sigfap.admin.json.research.Result result = new com.sigfap.admin.json.research.Result();

				result.getValue().add(research);

				result1.use(Results.json()).from(result).recursive()
						.serialize();

			} catch (JDBCConnectionException e) {

				com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
						"Problema de conexão com o banco.");
				result1.use(Results.json()).from(error).recursive().serialize();

			} catch (Exception e) {
				com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
						"Impossível cadastrar pesquisador.");
				result1.use(Results.json()).from(error).serialize();
				result1.include(error);
			}
		}

	}

	@Public
	@Put("/v1/researcher")
	public void editarPesquisador(Research research, Address address,
			Address address2, Integer etniaId, Integer areaId,
			Telephone telephone) {

		if ((research.getEmail() == null) || (research.getSenha() == null)) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Preencher as informações de login.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else if ((research.getNome() == null) || (research.getCpf() == null)
				|| (research.getRg() == null)
				|| (research.getRgEmissor() == null)
				|| (research.getRgDataEmissor() == null)
				|| (research.getMae() == null) || (research.getPai() == null)
				|| (research.getNascimento() == null)
				|| (research.getSexo() == null)) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Preencher as informações de dados cadastrais.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else if ((research.getEscolaridade() == null)
				|| (research.getModalidadeBolsa() == null)
				|| (research.getObjConcessao() == null)) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Preencher as informações de dados escolares.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else if ((etniaId == null) || (areaId == null)
				|| (telephone.getNumero() == null)) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Preencher as informações adicionais de etnia, área de conhecimento ou telefone.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else if ((address.getRua() == null) || (address.getNumero() == null)
				|| (address.getBairro() == null)
				|| (address.getCepZip() == null) || (address2.getRua() == null)
				|| (address2.getNumero() == null)
				|| (address2.getBairro() == null)
				|| (address2.getCepZip() == null)) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Preencher as informações de endereços.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} /*else if (verificador.verificaCpf(research.getCpf()) == false) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"CPF inválido.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}*/ else {
			try {
				dao1.update(address);
				dao1.update(address2);

				if ((research.getNome() == null)
						|| (research.getEmail() == null)
						|| (research.getSenha() == null)) {
					com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
							"O campo precisa ser preenchido.");
					result1.use(Results.json()).from(error).serialize();
					result1.include(error);
					return;
				} else {
					research.setSenha(DigestUtils.shaHex(research.getSenha()));
					dao.update(research);

					com.sigfap.admin.json.research.Result result = new com.sigfap.admin.json.research.Result();

					result.getValue().add(research);

					result1.use(Results.json()).from(result).recursive()
							.serialize();
					result1.include(result);
				}
			} catch (JDBCConnectionException e) {

				com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
						"Problema de conexão com o banco.");
				result1.use(Results.json()).from(error).recursive().serialize();

			} catch (Exception e) {
				com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
						"Impossível editar pesquisador.");

				result1.use(Results.json()).from(error).serialize();
				result1.include(error);
			}
		}
	}

	@Public
	@Delete("/v1/researcher/{id}")
	public void removerPesquisador(int id) {
		Research research = dao.findById(id);
		try {
			dao.deleteById(id);
			com.sigfap.admin.json.research.Result result = new com.sigfap.admin.json.research.Result();

			result.getValue().add(research);

			result1.use(Results.json()).from(result).recursive().serialize();
			result1.include(result);
		} catch (JDBCConnectionException e) {

			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Problema de conexão com o banco.");
			result1.use(Results.json()).from(error).recursive().serialize();

		} catch (Exception e) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Pesquisador não encontrado.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}
	}
}