<!-- Main Sidebar Container -->
	  <aside class="main-sidebar sidebar-dark-primary elevation-4">
	    <!-- Brand Logo -->
	    <a href="#" class="brand-link">
	      <span class="brand-text font-weight-light">KCMMS</span>
	    </a>
	
	    <!-- Sidebar -->
	    <div class="sidebar">
	      <!-- Sidebar user panel (optional) -->
	      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
	        <div class="info">
	          <a href="#" class="d-block"><c:out value='${member.membername}' /></a>
	        </div>
	      </div>
	
	      <!-- Sidebar Menu -->
	      <nav class="mt-2">
	        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
	          <!-- Add icons to the links using the .nav-icon class
	               with font-awesome or any other icon font library -->
	          
	          <li class="nav-header">Navigation</li>
			  
			  <li class="nav-item">
	            <a href="main_page.html" class="nav-link active">
	              <i class="nav-icon fas fa-home"></i>
	              <p>
	                Main Page
	              </p>
	            </a>
	          </li>
			  
			  <li class="nav-header">Admin</li>
			  
			  <li class="nav-item">
	            <a href="profile.html" class="nav-link">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                Profile
	              </p>
	            </a>
	          </li>
			  
			  <li class="nav-item">
	            <a href="#" class="nav-link">
	              <i class="nav-icon fas fa-users"></i>
	              <p>
	                Member
	                <i class="fas fa-angle-left right"></i>
	              </p>
	            </a>
	            <ul class="nav nav-treeview">
	              <li class="nav-item">
	                <a href="admin_member_applicant.php" class="nav-link">
	                  <i class="far fa-circle nav-icon"></i>
	                  <p>New Member Applicant</p>
	                </a>
	              </li>
				  <li class="nav-item">
	                <a href="admin_add_member.jsp" class="nav-link">
	                  <i class="far fa-circle nav-icon"></i>
	                  <p>Add Member</p>
	                </a>
	              </li>
				  <li class="nav-item">
	                <a href="admin_list_members.php" class="nav-link">
	                  <i class="far fa-circle nav-icon"></i>
	                  <p>View Member</p>
	                </a>
	              </li>
	            </ul>
	          </li>
			  
			  <li class="nav-item">
	            <a href="#" class="nav-link">
	              <i class="nav-icon fas fa-coins"></i>
	              <p>
	                Fund
	                <i class="fas fa-angle-left right"></i>
	              </p>
	            </a>
	            <ul class="nav nav-treeview">
	              <li class="nav-item">
	                <a href="admin_fund_list.php" class="nav-link">
	                  <i class="far fa-circle nav-icon"></i>
	                  <p>View Fund</p>
	                </a>
	              </li>
				  <li class="nav-item">
	                <a href="admin_add_fund.php" class="nav-link">
	                  <i class="far fa-circle nav-icon"></i>
	                  <p>Add New Fund</p>
	                </a>
	              </li>
	            </ul>
	          </li>
			  
			  <li class="nav-item">
	            <a href="Report.php" class="nav-link">
	              <i class="nav-icon fas fa-file"></i>
	              <p>
	                Report
	              </p>
	            </a>
	          </li>
			  
			  <li class="nav-item">
	            <a href="#" class="nav-link">
	              <i class="nav-icon fas fa-user-tie"></i>
	              <p>
	                Admin
	                <i class="fas fa-angle-left right"></i>
	              </p>
	            </a>
	            <ul class="nav nav-treeview">
	              <li class="nav-item">
	                <a href="admin_list_admins.php" class="nav-link">
	                  <i class="far fa-circle nav-icon"></i>
	                  <p>View Admin</p>
	                </a>
	              </li>
				  <li class="nav-item">
	                <a href="admin_add_admins.php" class="nav-link">
	                  <i class="far fa-circle nav-icon"></i>
	                  <p>Add Admin</p>
	                </a>
	              </li>
	            </ul>
	          </li>
			  
			  
	        </ul>
	      </nav>
	      <!-- /.sidebar-menu -->
	    </div>
	    <!-- /.sidebar -->
	  </aside>