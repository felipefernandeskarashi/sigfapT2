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
			<li class="active"><a href="${pageContext.request.contextPath}/"
				title="Principal"><i class="fa fa-lg fa-fw fa-home"></i> <span
					class="menu-item-parent">Principal</span></a></li>
			<li><a><i class="fa fa-lg fa-fw fa-university"></i> <span
					class="menu-item-parent">Institui&ccedil&atildeo</span></a>
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/registrar-instituicao"
						title="Criar Instituição"><i class="fa fa-lg fa-fw fa-plus"></i>
							<span class="menu-item-parent">Criar Institui&ccedil&atildeo</span></a></li>
					<li><a
						href="${pageContext.request.contextPath}/buscar-instituicao"
						title="Buscar Instituição"><i class="fa fa-lg fa-fw fa-search"></i>
							<span class="menu-item-parent">Buscar Institui&ccedil&atildeo</span></a></li>
					<li><a
						href="${pageContext.request.contextPath}/vincular-instituicao"
						title="Vincular Instituição"><i
							class="fa fa-lg fa-fw fa-chain"></i> <span
							class="menu-item-parent">Vincular Institui&ccedil&atildeo</span></a></li>
					<li><a
						href="${pageContext.request.contextPath}/registrar-instituicao-sugerida"
						title="Sugerir Instituição"><i class="fa fa-lg fa-fw fa-send"></i>
							<span class="menu-item-parent">Sugerir Institui&ccedil&atildeo</span></a></li>
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
					<li><a href="${pageContext.request.contextPath}/list/researchers"
						title="Listar Pesquisadores"><i
							class="fa fa-lg fa-fw fa-list-ul"></i> <span
							class="menu-item-parent">Listar Pesquisadores</span></a></li>
					<li><a href="${pageContext.request.contextPath}/find/research"
						title="Buscar Pesquisador"><i
							class="fa fa-lg fa-fw fa-search"></i> <span
							class="menu-item-parent">Buscar Pesquisador</span></a></li>
					<li><a href="${pageContext.request.contextPath}/edit/research/find"
						title="Editar Pesquisador"><i
							class="fa fa-lg fa-fw fa-edit"></i> <span
							class="menu-item-parent">Editar Pesquisador</span></a></li>
					<li><a href="${pageContext.request.contextPath}/remove/research/find"
						title="Remover Pesquisador"><i
							class="fa fa-lg fa-fw fa-times"></i> <span
							class="menu-item-parent">Remover Pesquisador</span></a></li>
				</ul></li>
				
			<li><a><i class="fa fa-lg fa-fw fa-user"></i> <span
					class="menu-item-parent">Etnia</span></a>
			<ul>		
					<li><a href="${pageContext.request.contextPath}/register"
						title="Inserir Etnia"><i class="fa fa-lg fa-fw fa-plus"></i>
							<span class="menu-item-parent">Inserir Etnia</span></a></li>
					<li><a href="${pageContext.request.contextPath}/list"
						title="Listar Etnias"><i
							class="fa fa-lg fa-fw fa-list-ul"></i> <span
							class="menu-item-parent">Listar Etnias</span></a></li>		
							
			</ul>
				
				
		</ul>
		
				
	</nav>
	<span class="minifyme" data-action="minifyMenu"> <i
		class="fa fa-arrow-circle-left hit"></i>
	</span>

</aside>
<!-- END NAVIGATION -->