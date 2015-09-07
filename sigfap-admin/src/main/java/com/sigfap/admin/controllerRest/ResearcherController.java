package com.sigfap.admin.controllerRest;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.exception.JDBCConnectionException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
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
import com.sigfap.admin.validation.CheckEmail;
import com.sigfap.admin.validation.CheckRg;
import com.sigfap.admin.validation.CheckTelefone;

@Controller
public class ResearcherController {

	private final Result result1;

	@Inject
	private CheckCpf verificadorCpf;

	@Inject
	private CheckRg verificadorRg;

	@Inject
	private CheckEmail verificadorEmail;

	@Inject
	private CheckTelefone verificadorTelefone;

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
	protected ResearcherController() {
		this(null);
	}

	@Inject
	public ResearcherController(Result result1) {
		this.result1 = result1;
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

		String validaEmail = research.getEmail();
		String validaCpf = research.getCpf();
		String validaRg = research.getRg();
		String validaTelefone = telephone.getNumero();

		// Campos obrigatórios de pesquisador nacional e estrangeiro

		if (research.getNome() == null) {
			com.sigfap.admin.json.research.Error error1 = new com.sigfap.admin.json.research.Error(
					"Preencher nome.");
			result1.use(Results.json()).from(error1).recursive().serialize();
			result1.include(error1);
			return;
		}

		if (research.getSenha() == null) {
			com.sigfap.admin.json.research.Error error2 = new com.sigfap.admin.json.research.Error(
					"Preencher senha.");
			result1.use(Results.json()).from(error2).recursive().serialize();
			result1.include(error2);
			return;
		}

		if (verificadorEmail.isEmail(validaEmail) == false) {
			com.sigfap.admin.json.research.Error error3 = new com.sigfap.admin.json.research.Error(
					"Preencher e-mail válido.");
			result1.use(Results.json()).from(error3).recursive().serialize();
			result1.include(error3);
			return;
		}

		if (areaId == null) {
			com.sigfap.admin.json.research.Error error4 = new com.sigfap.admin.json.research.Error(
					"Preencher área de conhecimento.");
			result1.use(Results.json()).from(error4).recursive().serialize();
			result1.include(error4);
			return;
		}

		if (etniaId == null) {
			com.sigfap.admin.json.research.Error error5 = new com.sigfap.admin.json.research.Error(
					"Preencher etnia.");
			result1.use(Results.json()).from(error5).recursive().serialize();
			result1.include(error5);
			return;
		}

		if (verificadorTelefone.isTelefone(validaTelefone) == false) {
			com.sigfap.admin.json.research.Error error6 = new com.sigfap.admin.json.research.Error(
					"Preencher número de telefone válido.");
			result1.use(Results.json()).from(error6).recursive().serialize();
			result1.include(error6);
			return;
		}

		if ((research.isEstrangeiro() == false)
				&& (verificadorCpf.isCpf(validaCpf) == false)) {
			com.sigfap.admin.json.research.Error error7 = new com.sigfap.admin.json.research.Error(
					"Preencher CPF válido.");
			result1.use(Results.json()).from(error7).recursive().serialize();
			result1.include(error7);
			return;
		}

		if ((research.isEstrangeiro() == false)
				&& (verificadorRg.isRg(validaRg) == false)) {
			com.sigfap.admin.json.research.Error error8 = new com.sigfap.admin.json.research.Error(
					"Preencher RG válido.");
			result1.use(Results.json()).from(error8).recursive().serialize();
			result1.include(error8);
			return;
		}

		else {

			try {

				dao1.persist(address);
				dao1.persist(address2);

				research.setEnderecoRes(address);
				research.setEnderecoCom(address2);

			} catch (Exception e) {
				com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
						"Impossível cadastrar endereço de pesquisador.");
				result1.use(Results.json()).from(error).serialize();
				result1.include(error);
				return;
			}

			try {

				research.setEtniaPes(dao2.findById(etniaId));
				research.setArea(dao3.findById(areaId));

				research.setSenha(DigestUtils.shaHex(research.getSenha()));
				research.setAtivo(true);

				telephone.setPesquisador(research);
				dao4.persist(telephone);

				research.setTelefone(telephone);

				dao.persist(research);

				Research salvo = dao.findById(research.getId());

				com.sigfap.admin.json.research.Result result = new com.sigfap.admin.json.research.Result();
				result.getValue().add(salvo);

				result1.use(Results.json()).from(result).include("value").include("value.enderecoRes").include("value.enderecoCom")
				.include("value.etniaPes").include("value.area")
				.include("value.telefones")
				.exclude("value.pesquisadorUnidades").serialize();
				result1.include(result);

			} catch (JDBCConnectionException e) {

				com.sigfap.admin.json.research.Error error3 = new com.sigfap.admin.json.research.Error(
						"Problema de conexão com o banco.");
				result1.use(Results.json()).from(error3).recursive()
						.serialize();
				result1.include(error3);
				return;

			} catch (Exception e) {
				com.sigfap.admin.json.research.Error error4 = new com.sigfap.admin.json.research.Error(
						"Impossível cadastrar pesquisador.");
				result1.use(Results.json()).from(error4).serialize();
				result1.include(error4);
				return;
			}

		}

	}

	@Public
	@Put("/v1/researcher")
	public void editarPesquisador(Research research) {

		String validaEmail2 = research.getEmail();

		if (verificadorEmail.isEmail(validaEmail2) == false) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"E-mail inválido.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
			return;
		}

		if (research.getSenha() != null) {
			research.setSenha(DigestUtils.shaHex(research.getSenha()));
		}

		try {

			dao.update(research);

			com.sigfap.admin.json.research.Result result = new com.sigfap.admin.json.research.Result();
			result.getValue().add(research);
			result1.use(Results.json()).from(result).include("value").include("value.enderecoRes").include("value.enderecoCom")
			.include("value.etniaPes").include("value.area")
			.include("value.telefones")
			.exclude("value.pesquisadorUnidades").serialize();
			result1.include(result);
		}

		catch (Exception e) {
			com.sigfap.admin.json.research.Error error2 = new com.sigfap.admin.json.research.Error(
					"Impossível editar pesquisador.");
			result1.use(Results.json()).from(error2).serialize();
			result1.include(error2);
		}

	}

	@Public
	@Delete
	@Path("/v1/researcher/{id}")
	public void removerPesquisador(int id) {

		Research research = dao.findById(id);

		try {

			dao.deleteById(id);

			com.sigfap.admin.json.research.Result result = new com.sigfap.admin.json.research.Result();
			result.getValue().add(research);

			result1.use(Results.json()).from(result).include("value").include("value.enderecoRes").include("value.enderecoCom")
			.include("value.etniaPes").include("value.area")
			.include("value.telefones")
			.exclude("value.pesquisadorUnidades").serialize();
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