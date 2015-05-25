<!DOCTYPE html>
<html lang="en-us" id="extr-page">
<head>
<meta charset="utf-8">
<title>sigfap</title>
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- #CSS Links -->
<!-- Basic Styles -->
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/static/css/font-awesome.min.css">

<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/static/css/smartadmin-production.min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/static/css/smartadmin-skins.min.css">

<!-- SmartAdmin RTL Support is under construction
			 This RTL CSS will be released in version 1.5
		<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/static/css/smartadmin-rtl.min.css"> -->

<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/static/css/your_style.css"> -->

<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/static/css/demo.min.css">

<!-- #FAVICONS -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/static/img/favicon/favicon.ico"
	type="image/x-icon">
<link rel="icon"
	href="${pageContext.request.contextPath}/static/img/favicon/favicon.ico"
	type="image/x-icon">

<!-- #GOOGLE FONT -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

<!-- #APP SCREEN / ICONS -->
<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath}/static/img/splash/sptouch-icon-iphone.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="${pageContext.request.contextPath}/static/img/splash/touch-icon-ipad.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="${pageContext.request.contextPath}/static/img/splash/touch-icon-iphone-retina.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="${pageContext.request.contextPath}/static/img/splash/touch-icon-ipad-retina.png">

<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<!-- Startup image for web apps -->
<link rel="apple-touch-startup-image"
	href="${pageContext.request.contextPath}/static/img/splash/ipad-landscape.png"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
<link rel="apple-touch-startup-image"
	href="${pageContext.request.contextPath}/static/img/splash/ipad-portrait.png"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
<link rel="apple-touch-startup-image"
	href="${pageContext.request.contextPath}/static/img/splash/iphone.png"
	media="screen and (max-device-width: 320px)">

</head>

<!--<body class="animated fadeInDown"> -->

<body id="login" onLoad="setDisabled();setCampos();">
		<!-- possible classes: minified, no-right-panel, fixed-ribbon, fixed-header, fixed-width-->
		<header id="header">
			<!--<span id="logo"></span>-->
			<div id="logo-group">
				<span id="logo"> <img src="${pageContext.request.contextPath}/static/img/logo.png" alt="SmartAdmin"> </span>
		</header>
		
	<div id="main" role="main">

		<!-- MAIN CONTENT -->
		<div id="content" class="container">

			<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
				<div class="well no-padding">
					<form action="${pageContext.request.contextPath}/editResearch"
						method="post" id="smart-form-register" class="smart-form client-form">
						
						<header> 
							Editar Pesquisador 
						</header>

						<fieldset>
							<section>
								<label class="input">Pesquisador Estrangeiro</label> <input type="checkbox"
										value="1" name="pesq_estr" id="pesq_estr" onClick="Hab();Des();"/> 
							</section>
							<section>
								<label class="label">Nome do Pesquisador</label> <label
									class="input"> <i class="icon-append fa fa-user"></i> <input
									type="text" name="edit.nome" value="${edit.nome}" size="50"required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-user txt-color-teal"></i> Por favor informe o seu
										nome completo</b>
								</label>
							</section>

							<section>
								<label class="label">CPF</label> <label class="input"> <i
									class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.cpf" value="${edit.cpf}" id="cpf" size="14" required="required" placeholder="Ex.: 000.000.000-00"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu CPF</b>
								</label>
							</section>

							<section>
								<label class="label">RG</label> <label class="input"> <i
									class="icon-append fa fa-lock"></i><input type="text"
									name="edit.rg" value="${edit.rg}" id="rg" size="12" required="required" placeholder="Ex.: 00.000.000-0"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu RG</b>
								</label>
							</section>

							<section>
								<label class="label">Órgão Emissor</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.rgEmissor" value="${edit.rgEmissor}" size="50" id="orgaoEm" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu Órgão
										Emissor</b>
								</label>
							</section>

							<section>
								<label class="label">Data de Emissão</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="date" name="edit.rgDataEmissor" value="${edit.rgDataEmissor}" id="dataEm" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe a Data de
										Emissão</b>
								</label>
							</section>

							<section>
								<label class="label">Estado de Emissão</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.rgEstadoEmissor" value="${edit.rgEstadoEmissor}" size="50" id="estadoEm" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu Estado de
										Emissão</b>
								</label>
							</section>

							<section>
								<label class="label">Data de Nascimento</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="date" name="edit.nascimento" value="${edit.nascimento}" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe a sua Data de
										Nascimento</b>
								</label>
							</section>

							<section>
 									<label class="label">Sexo</label> 
 									<select name="edit.sexo" id="sexo">
									<option value="Masculino">Masculino</option>
									<option value="Feminino">Feminino</option>
									</select>
							</section>
									
							<section>
								<label class="label">Etnia</label> 
								<select name="edit.etniaId" id="etnia">
									<option value="17">Parda</option>
									<option value="14">Branca</option>
									<option value="16">Negra</option>
									<option value="15">Indígena</option>
									<option value="13">Amarela</option>
									
								</select>
							</section>

							<section>
								<label class="label">Nome da Mãe</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.mae" value="${edit.mae}" size="50" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o nome de sua
										Mãe</b>
								</label>
							</section>

							<section>
								<label class="label">Nome do Pai</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.pai" value="${edit.pai}" size="50" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o nome de seu
										Pai</b>
								</label>
							</section>

							<section>
								<h2>Endereço Residêncial</h2>
								<label class="label">Rua</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.rua" value="${edit.rua}" size="50" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe a rua</b>
								</label> <br>
								<label class="label">Número</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.numero" value="${edit.numero}" size="50" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o número</b>
								</label> <br>
								<label class="label">Complemento</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.complemento" value="${edit.complemento}" size="50"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o complemento</b>
								</label> <br>
								<label class="label">Bairro</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.bairo"  value="${edit.bairo}" size="50" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o bairro</b>
								</label> <br>
								<label class="label">CEP</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.cep" required="required" value="${edit.cep}" size="50"  placeholder="Ex.: 00000-000"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o CEP</b>
								</label><br>
								<label class="label">Endereço Cidade Estrangeira</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.cidadeEstrangeira" value="${edit.cidadeEstrangeira}" size="200" id="cidadeEsRE" > <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o endereço residêncial caso não resida no Brasil</b>
								</label>
							</section>

							<section>
								<h2>Endereço Comercial</h2>
								<label class="label">Rua</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.rua" value="${edit.rua}" size="50" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe a rua</b>
								</label> <br>
								<label class="label">Número</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.numero" value="${edit.numero}" size="50"  required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o número</b>
								</label> <br>
								<label class="label">Complemento</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.complemento" value="${edit.complemento}" size="50"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o complemento</b>
								</label> <br>
								<label class="label">Bairro</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.bairro" value="${edit.bairro}" size="50" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o bairro</b>
								</label> <br>
								<label class="label">CEP</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.cep" value="${edit.cep}" size="50" required="required"  placeholder="Ex.: 00000-000"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o CEP</b>
								</label><br>
								<label class="label">Endereço Cidade Estrangeira</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.cidadeEstrangeira" value="${edit.cidadeEstrangeira}" size="200" id="cidadeEsCo"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o endereço comercial caso não resida no Brasil</b>
								</label>
							</section>
							
							<section>
								<label class="label">Endereço Preferencial</label> 
									<select name="edit.enderecoPref" id="endPref">
									<option value="1">Endereço Residencial</option>
									<option value="0">Endereço Comercial</option>
									</select>
							</section>
							
							<section>
								<label class="label">País</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.pais" value="${edit.pais}" size="50" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu País</b>
								</label>
							</section>

							<section>
								<label class="label">Telefone</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="tel"
									name="edit.numero" value="${edit.numero}" size="50" required="required" maxlength="15"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu Telefone</b>
								</label>
							</section>

							<section>
								<label class="label">Currículo</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.curriculo" value="${edit.curriculo}" size="500"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu Currículo</b>
								</label>
							</section>

							<section>
								<label class="label">Escolaridade</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.escolaridade" value="${edit.escolaridade}" size="50" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe a sua
										Escolariedade</b>
								</label>
							</section>

							<section>
								<label class="label">Vínculo Empregatício</label> 
									<select name="edit.vinculoEmpregaticio" id="vinEmp">
										<option value="1">Sim</option>
										<option value="0">Não</option>
									</select>
							</section>

							<section>
								<label class="label">Vínculo Institucional</label>
									<select name="edit.vinculoInstitucional" id="vinIns">
										<option value="1">Sim</option>
										<option value="0">Não</option>
									</select>
							</section>

							<section>
								<label class="label">Departamento</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.departamento"  value="${edit.departamento}" size="50"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu
										Departamento</b>
								</label>
							</section>

							<section>
								<label class="label">Tempo de Serviço</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.tempoServico" value="${edit.tempoServico}" size="50"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu Tempo de
										Serviço</b>
								</label>
							</section>

							<section>
								<label class="label">Regime</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.regime" value="${edit.regime}" size="50"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu Regime</b>
								</label>
							</section>

							<section>
								<label class="label">Cargo</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.cargo" value="${edit.cargo}" size="50"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu Cargo</b>
								</label>
							</section>

							<section>
								<label class="label">Tempo de Cargo</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.tempoCargo" value="${edit.tempoCargo}" size="50"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu Tempo de
										Cargo</b>
								</label>
							</section>

							<section>
								<label class="label">Curso</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.curso" value="${edit.curso}" size="50"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu Curso</b>
								</label>
							</section>

							<section>
								<label class="label">Tipo</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.tipo" value="${edit.tipo}" size="50"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o tipo de pesquisador que você é.</b>
								</label>
							</section>

							<section>
								<label class="label">Passaporte</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.passaporte" value="${edit.passaporte}" size="50"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu
										Passaporte</b>
								</label>
							</section>

							<section>
								<label class="label">Categoria</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="text"
									name="edit.categoria" value="${edit.categoria}" size="50"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe a sua Categoria</b>
								</label>
							</section>

							<section>
								<label class="label">Modalidade de Bolsa</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.modalidadeBolsa" value="${edit.modalidadeBolsa}" size="50" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe a sua
										Modalidade de Bolsa</b>
								</label>
							</section>

							<section>
								<label class="label">Objeto de Concessão</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.objConcessao" value="${edit.objConcessao}" size="50" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu Objeto de
										Concessão</b>
								</label>
							</section>

							<section>
								<label class="label">Currículo Lattes URL</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="text" name="edit.urlLattes" value="${edit.urlLattes}" size="500"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu Currícluo
										Lattes URL</b>
								</label>
							</section>

							<section>
								<label class="label">Área de Conhecimento</label>
								<select name="edit.areaId" id="area">
								<option value="1">Ciências Exatas e da Terra</option>
								<option value="2">Ciências Biológicas</option>
								<option value="3">Engenharias</option>
								<option value="4">Ciências da saúde</option>
								<option value="5">Ciências Agrárias</option>
								<option value="6">Ciências Sociais Aplicadas</option>
								<option value="7">Ciências Humanas, Linguísticas e Letras e Arte</option>
								</select>
							</section>
								
							<section>
								<label class="label">Disponibilidade para Viajar</label> 
								<select name="edit.dispoViajar" id="dispVi">
								<option value="1">Sim</option>
								<option value="0">Não</option>
								</select>
							</section>
								
							<section>
								<label class="label">Receber Informações</label>
								<select name="edit.receberInfo" id="info">
								<option value="1">Sim</option>
								<option value="0">Não</option>
								</select>
							</section>
							
							<section>
								<label class="label">E-mail</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="email"
									name="edit.email" value="${edit.email}" size="50" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Informe o seu E-mail</b>
								</label>
							</section>
							
							<section>
								<label class="label">Senha</label> <label class="input">
									<i class="icon-append fa fa-lock"></i> <input type="password"
									name="edit.senha" value="${edit.senha}" size="500" required="required"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> Crie uma senha para logar no sistema</b>
								</label>
							</section>

						</fieldset>
						<footer>
							<button type="submit" class="btn btn-primary">Cadastrar
								Pesquisador</button>
						</footer>
					</form>

				</div>
			</div>
		</div>
	</div>

	</div>

	<!--================================================== -->

	<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/pace/pace.min.js"></script>

	<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script>
		if (!window.jQuery) {
			document
					.write('<script src="${pageContext.request.contextPath}/static/js/libs/jquery-2.0.2.min.js"><\/script>');
		}
	</script>

	<script
		src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
	<script>
		if (!window.jQuery.ui) {
			document
					.write('<script src="${pageContext.request.contextPath}/static/js/libs/jquery-ui-1.10.3.min.js"><\/script>');
		}
	</script>

	<!-- JS TOUCH : include this plugin for mobile drag / drop touch events 		
		<script src="${pageContext.request.contextPath}/static/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

	<!-- BOOTSTRAP JS -->
	<script
		src="${pageContext.request.contextPath}/static/js/bootstrap/bootstrap.min.js"></script>

	<!-- JQUERY VALIDATE -->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/jquery-validate/jquery.validate.min.js"></script>

	<!-- JQUERY MASKED INPUT -->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

	<!--[if IE 8]>
			
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
			
		<![endif]-->

	<!-- MAIN APP JS FILE -->
	<script src="${pageContext.request.contextPath}/static/js/app.min.js"></script>
	
		<!-- Validação pesquisador estrangeiro	-->
		<script language="javascript" type="text/javascript">
			function Hab() {
				if (document.getElementById("pesq_estr").checked==true) {
					document.getElementById("cpf").disabled=true;
				} else {
					document.getElementById("cpf").disabled=false;
				}
			}
			function Des() {
				if (document.getElementById("pesq_estr").checked==true) {
					document.getElementById("cpf").disabled=true;
					document.getElementById("rg").disabled=true;
					document.getElementById("orgaoEm").disabled=true;
					document.getElementById("dataEm").disabled=true;
					document.getElementById("estadoEm").disabled=true;
				} else {
					document.getElementById("cpf").disabled=false;
					document.getElementById("rg").disabled=false;
					document.getElementById("orgaoEm").disabled=false;
					document.getElementById("dataEm").disabled=false;
					document.getElementById("estadoEm").disabled=false;
					document.getElementById("cidadeEsRE").disabled=true;
					document.getElementById("cidadeEsCo").disabled=true;
				}
			}
			function setDisabled() {
				document.getElementById("cpf").disabled=true;
			}
			
			function setCampos() {
				
				switch("${edit.sexo}"){
				case "Masculino":
					document.getElementById("sexo").options[0].selected = true;
					break;
				case "Feminino":
					document.getElementById("sexo").options[1].selected = true;
					break;
				default:
					break;
				}
				
				switch("${edit.etniaId}"){
				case "17":
					document.getElementById("etnia").options[0].selected = true;
					break;
				case "14":
					document.getElementById("etnia").options[1].selected = true;
					break;
				case "16":
					document.getElementById("etnia").options[2].selected = true;
					break;
				case "15":
					document.getElementById("etnia").options[3].selected = true;
					break;
				case "13":
					document.getElementById("etnia").options[4].selected = true;
					break;
				default:
					break;
				}
				
				switch("${edit.enderecoPref}"){
				case "1":
					document.getElementById("endPref").options[0].selected = true;
					break;
				case "0":
					document.getElementById("endPref").options[1].selected = true;
					break;
				default:
					break;
				}
				
				switch("${edit.vinculoEmpregaticio}"){
				case "1":
					document.getElementById("vinEmp").options[0].selected = true;
					break;
				case "0":
					document.getElementById("vinEmp").options[1].selected = true;
					break;
				default:
					break;
				}
				
				switch("${edit.vinculoInstitucional}"){
				case "1":
					document.getElementById("vinIns").options[0].selected = true;
					break;
				case "0":
					document.getElementById("vinIns").options[1].selected = true;
					break;
				default:
					break;
				}
				
				switch("${edit.areaId}"){
				case "1":
					document.getElementById("area").options[0].selected = true;
					break;
				case "2":
					document.getElementById("area").options[1].selected = true;
					break;
				case "3":
					document.getElementById("area").options[2].selected = true;
					break;
				case "4":
					document.getElementById("area").options[3].selected = true;
					break;
				case "5":
					document.getElementById("area").options[4].selected = true;
					break;
				case "6":
					document.getElementById("area").options[5].selected = true;
					break;
				case "7":
					document.getElementById("area").options[6].selected = true;
					break;
				default:
					break;
				}
				
				switch("${edit.dispoViajar}"){
				case "1":
					document.getElementById("dispVi").options[0].selected = true;
					break;
				case "0":
					document.getElementById("dispVi").options[1].selected = true;
					break;
				default:
					break;
				}
				
				switch("${edit.receberInfo}"){
				case "1":
					document.getElementById("info").options[0].selected = true;
					break;
				case "0":
					document.getElementById("info").options[1].selected = true;
					break;
				default:
					break;
				}
				
			}
			
			
			
		</script>
		


</body>
</html>