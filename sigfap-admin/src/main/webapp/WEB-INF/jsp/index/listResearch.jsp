<%@ include file="../partials/header.jsp"%>
<%@ include file="../partials/top.jsp"%>

<!-- Left panel : Navigation area -->
<!-- Note: This width of the aside area can be adjusted through LESS variables -->
<aside id="left-panel">

	<!-- User info -->
	<div class="login-info">
		<span> <!-- User image size is adjusted inside CSS, it should stay as it -->
			<a href="javascript:void(0);" id="show-shortcut"
			data-action="toggleShortcut"> <img
				src="${pageContext.request.contextPath}/static/img/avatars/sunny.png"
				alt="me" class="online" /> <span> john.doe </span> <i
				class="fa fa-angle-down"></i>
		</a>
		</span>
	</div>
	<!-- end user info -->
	<!-- NAVIGATION : This navigation is also responsive
	To make this navigation dynamic please make sure to link the node
	(the reference to the nav > ul) after page load. Or the navigation
	will not initialize.
	-->
	<nav>
		<!-- NOTE: Notice the gaps after each icon usage <i></i>..
		Please note that these links work a bit different than
		traditional href="" links. See documentation for details.
		-->

		<ul>
			<li><a href="${pageContext.request.contextPath}/"
				title="Principal"><i class="fa fa-lg fa-fw fa-home"></i> <span
					class="menu-item-parent">Principal</span></a></li>
			<li><a><i class="fa fa-lg fa-fw fa-university"></i> <span
					class="menu-item-parent">Instituição</span></a>
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/registrar-instituicao"
						title="Criar Instituição"><i class="fa fa-lg fa-fw fa-plus"></i>
							<span class="menu-item-parent">Criar Instituição</span></a></li>
					<li><a
						href="${pageContext.request.contextPath}/buscar-instituicao"
						title="Buscar Instituição"><i class="fa fa-lg fa-fw fa-search"></i>
							<span class="menu-item-parent">Buscar Instituição</span></a></li>
					<li><a
						href="${pageContext.request.contextPath}/vincular-instituicao"
						title="Vincular Instituição"><i
							class="fa fa-lg fa-fw fa-chain"></i> <span
							class="menu-item-parent">Vincular Instituição</span></a></li>
					<li><a
						href="${pageContext.request.contextPath}/registrar-instituicao-sugerida"
						title="Sugerir Instituição"><i class="fa fa-lg fa-fw fa-send"></i>
							<span class="menu-item-parent">Sugerir Instituição</span></a></li>
				</ul></li>

			<li><a><i class="fa fa-lg fa-fw fa-sitemap"></i> <span
					class="menu-item-parent">Unidade</span></a>
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/inserir-unidade"
						title="Inserir Unidade"><i class="fa fa-lg fa-fw fa-plus"></i>
							<span class="menu-item-parent">Inserir Unidade</span></a></li>
					<li><a href="${pageContext.request.contextPath}/unit/buscar"
						title="Gerenciar Unidade"><i class="fa fa-lg fa-fw fa-retweet"></i>
							<span class="menu-item-parent">Gerenciar Unidade</span></a></li>
				</ul></li>

			<li><a><i class="fa fa-lg fa-fw fa-user"></i> <span
					class="menu-item-parent">Pesquisador</span></a>
				<ul>
					<li class="active"><a
						href="${pageContext.request.contextPath}/list/researchers"
						title="Listar Pesquisadores"><i
							class="fa fa-lg fa-fw fa-list-ul"></i> <span
							class="menu-item-parent">Listar Pesquisadores</span></a></li>
					<li><a href="${pageContext.request.contextPath}/find/research"
						title="Buscar Pesquisador"><i class="fa fa-lg fa-fw fa-search"></i>
							<span class="menu-item-parent">Buscar Pesquisador</span></a></li>
					<li><a href="${pageContext.request.contextPath}/edit/research/find"
						title="Editar Pesquisador"><i class="fa fa-lg fa-fw fa-edit"></i>
							<span class="menu-item-parent">Editar Pesquisador</span></a></li>
					<li><a href="${pageContext.request.contextPath}/remove/research/find"
						title="Remover Pesquisador"><i class="fa fa-lg fa-fw fa-times"></i>
							<span class="menu-item-parent">Remover Pesquisador</span></a></li>
				</ul></li>
		</ul>
	</nav>
	<span class="minifyme" data-action="minifyMenu"> <i
		class="fa fa-arrow-circle-left hit"></i>
	</span>

</aside>
<!-- END NAVIGATION -->

<body class="">
	<!-- possible classes: minified, fixed-ribbon, fixed-header, fixed-width-->
	<!-- MAIN PANEL -->
	<div id="main" role="main">
		<!-- RIBBON -->
		<div id="ribbon">
			<span class="ribbon-button-alignment"> <span id="refresh"
				class="btn btn-ribbon" data-action="resetWidgets"
				data-title="refresh" rel="tooltip" data-placement="bottom"
				data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings."
				data-html="true"> <i class="fa fa-refresh"></i>
			</span>
			</span>
			<!-- breadcrumb -->
			<ol class="breadcrumb">
				<li>Pesquisador</li>
				<li>Listar Pesquisadores</li>
			</ol>
			<!-- end breadcrumb -->

			<!-- You can also add more buttons to the
				ribbon for further usability
				Example below:
				<span class="ribbon-button-alignment pull-right">
				<span id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa-grid"></i> Change Grid</span>
				<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa-plus"></i> Add</span>
				<span id="search" class="btn btn-ribbon" data-title="search"><i class="fa-search"></i> <span class="hidden-mobile">Search</span></span>
				</span> -->
		</div>
		<!-- END RIBBON -->

		<!-- MAIN CONTENT -->
		<div id="content">
			<!-- widget grid -->
			<section id="widget-grid" class="">
				<!-- row -->
				<div class="row">
					<!-- NEW WIDGET START -->
					<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<!-- Widget ID (each widget will need unique ID)-->
						<div class="jarviswidget jarviswidget-color-blueDark"
							id="wid-id-1" data-widget-editbutton="false">
							<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">
								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"
								-->
							<header>
								<span class="widget-icon"> <i class="fa fa-table"></i>
								</span>
								<h2>Pesquisador | Listar Pesquisadores</h2>
							</header>
							<!-- widget div-->
							<div>
								<!-- widget edit box -->
								<div class="jarviswidget-editbox">
									<!-- This area used as dropdown edit box -->
								</div>
								<!-- end widget edit box -->
								<!-- widget content -->
								<div class="widget-body no-padding">
									<table id="datatable_fixed_column"
										class="table table-striped table-bordered" width="100%">
										<thead>
											<tr>
												<th data-class="expand">ID</th>
												<th>Nome</th>
												<th>Tipo</th>
												<th>Curso</th>
												<th>CPF</th>
												<th>Ativo</th>
												<th>Vizualizar | Editar | Remover</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="busca" items="${busca}">
												<tr>
													<td>${busca.id}</td>
													<td>${busca.nome}</td>
													<td>${busca.tipo}</td>
													<td>${busca.curso}</td>
													<td>${busca.cpf}</td>
													<td>${busca.ativoTexto}</td>
													<td><a
														href="${linkTo[IndexController].editResearchAdm}${busca.id}"
														class="btn btn-primary btn-circle btn-success"><i
															class="glyphicon glyphicon-info-sign"></i></a>
													<a href="${linkTo[IndexController].editResearchAdm}${busca.id}"
														class="btn btn-primary btn-circle btn-warning"><i
															class="glyphicon glyphicon-edit"></i></a> <a
														href="${linkTo[IndexController].remove}${busca.id}"
														class="btn btn-primary btn-circle btn-danger"><i
															class="glyphicon glyphicon-remove"></i></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- end widget content -->
							</div>
							<!-- end widget div -->
						</div>
						<!-- end widget -->
					</article>
				</div>
			</section>
			<!-- end widget grid -->
		</div>
		<!-- END MAIN CONTENT -->
	</div>
	<!-- END MAIN PANEL -->
	<!-- PAGE FOOTER -->
	<div class="page-footer">
		<div class="row">
			<div class="col-xs-12 col-sm-6">
				<span class="txt-color-white">SmartAdmin WebApp © 2013-2014</span>
			</div>

			<div class="col-xs-6 col-sm-6 text-right hidden-xs">
				<div class="txt-color-white inline-block">
					<i class="txt-color-blueLight hidden-mobile">Last account
						activity <i class="fa fa-clock-o"></i> <strong>52 mins
							ago &nbsp;</strong>
					</i>
					<div class="btn-group dropup">
						<button
							class="btn btn-xs dropdown-toggle bg-color-blue txt-color-white"
							data-toggle="dropdown">
							<i class="fa fa-link"></i> <span class="caret"></span>
						</button>
						<ul class="dropdown-menu pull-right text-left">
							<li>
								<div class="padding-5">
									<p class="txt-color-darken font-sm no-margin">Download
										Progress</p>
									<div class="progress progress-micro no-margin">
										<div class="progress-bar progress-bar-success"
											style="width: 50%;"></div>
									</div>
								</div>
							</li>
							<li class="divider"></li>
							<li>
								<div class="padding-5">
									<p class="txt-color-darken font-sm no-margin">Server Load</p>
									<div class="progress progress-micro no-margin">
										<div class="progress-bar progress-bar-success"
											style="width: 20%;"></div>
									</div>
								</div>
							</li>
							<li class="divider"></li>
							<li>
								<div class="padding-5">
									<p class="txt-color-darken font-sm no-margin">
										Memory Load <span class="text-danger">*critical*</span>
									</p>
									<div class="progress progress-micro no-margin">
										<div class="progress-bar progress-bar-danger"
											style="width: 70%;"></div>
									</div>
								</div>
							</li>
							<li class="divider"></li>
							<li>
								<div class="padding-5">
									<button class="btn btn-block btn-default">refresh</button>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END PAGE FOOTER -->

	<!--================================================== -->

	<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
	<script data-pace-options='{ "restartOnRequestAfter": true }'
		src="${pageContext.request.contextPath}/static/js/plugin/pace/pace.min.js"></script>

	<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script>
		if (!window.jQuery) {
			document
					.write('<script src="${pageContext.request.contextPath}/static/js/libs/jquery-2.0.2.min.js"><\/script>');
		}
	</script>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
	<script>
		if (!window.jQuery.ui) {
			document
					.write('<script src="${pageContext.request.contextPath}/static/js/libs/jquery-ui-1.10.3.min.js"><\/script>');
		}
	</script>

	<!-- IMPORTANT: APP CONFIG -->
	<script
		src="${pageContext.request.contextPath}/static/js/app.config.js"></script>

	<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script>

	<!-- BOOTSTRAP JS -->
	<script
		src="${pageContext.request.contextPath}/static/js/bootstrap/bootstrap.min.js"></script>

	<!-- CUSTOM NOTIFICATION -->
	<script
		src="${pageContext.request.contextPath}/static/js/notification/SmartNotification.min.js"></script>

	<!-- JARVIS WIDGETS -->
	<script
		src="${pageContext.request.contextPath}/static/js/smartwidgets/jarvis.widget.min.js"></script>

	<!-- EASY PIE CHARTS -->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

	<!-- SPARKLINES -->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/sparkline/jquery.sparkline.min.js"></script>

	<!-- JQUERY VALIDATE -->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/jquery-validate/jquery.validate.min.js"></script>

	<!-- JQUERY MASKED INPUT -->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

	<!-- JQUERY SELECT2 INPUT -->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/select2/select2.min.js"></script>

	<!-- JQUERY UI + Bootstrap Slider -->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

	<!-- browser msie issue fix -->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

	<!-- FastClick: For mobile devices -->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/fastclick/fastclick.min.js"></script>

	<!--[if IE 8]>
		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
		<![endif]-->

	<!-- Demo purpose only -->
	<script src="${pageContext.request.contextPath}/static/js/demo.min.js"></script>

	<!-- MAIN APP JS FILE -->
	<script src="${pageContext.request.contextPath}/static/js/app.min.js"></script>

	<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
	<!-- Voice command : plugin -->
	<script
		src="${pageContext.request.contextPath}/static/js/speech/voicecommand.min.js"></script>

	<!-- PAGE RELATED PLUGIN(S) -->

	<!-- Flot Chart Plugin: Flot Engine, Flot Resizer, Flot Tooltip -->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/flot/jquery.flot.cust.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/flot/jquery.flot.resize.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/flot/jquery.flot.tooltip.min.js"></script>

	<!-- Vector Maps Plugin: Vectormap engine, Vectormap language -->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/vectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/vectormap/jquery-jvectormap-world-mill-en.js"></script>

	<!-- Full Calendar -->
	<script
		src="${pageContext.request.contextPath}/static/js/plugin/fullcalendar/jquery.fullcalendar.min.js"></script>

</body>

</html>