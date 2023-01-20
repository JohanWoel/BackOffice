<%--
  Created by IntelliJ IDEA.
  User: tsiry
  Date: 11/10/2022
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link" href="<%= request.getContextPath() %>/soldes/attentes">
                <i class="bx bx-money"></i>
                <span>Valider un rechargement de compte</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#statistiques-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-graph-up"></i><span>Statistiques</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="statistiques-nav" class="nav-content collapse " data-bs-parent="#statistiques-nav">
                <li>
                    <a href="<%= request.getContextPath() %>/statistiques/nbmises">
                        <i class="bi bi-circle"></i><span>Nombre de mises par catégorie</span>
                    </a>
                </li>
                <li>
                    <a href="<%= request.getContextPath() %>/statistiques/avgmises">
                        <i class="bi bi-circle"></i><span>Moyenne de mise par catégorie</span>
                    </a>
                </li>
                <li>
                    <a href="<%= request.getContextPath() %>/statistiques/nbencheres">
                        <i class="bi bi-circle"></i><span>Nombre d'enchères par catégorie</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Components Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#configuration-nav" data-bs-toggle="collapse" href="#">
                <i class="ri-settings-3-line"></i><span>Configuration</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="configuration-nav" class="nav-content collapse " data-bs-parent="#configuration-nav">
                <li>
                    <a href="<%= request.getContextPath() %>/durees/insertion">
                        <i class="bi bi-circle"></i><span>Configurer durée enchères</span>
                    </a>
                </li>
                <li>
                    <a href="<%= request.getContextPath() %>/categories">
                        <i class="bi bi-circle"></i><span>Configurer les catégories</span>
                    </a>
                </li>
                <li>
                    <a href="<%= request.getContextPath() %>/produits">
                        <i class="bi bi-circle"></i><span>Configurer les produits</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Components Nav -->

    </ul>

</aside>
