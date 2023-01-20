<%@ page import="encheres.backoffice.models.Produit" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Produit> produits = (List<Produit>) request.getAttribute("produits");
%>
<main class="main" id="main">
    <div class="pagetitle">
        <h1>Produits</h1>
    </div>
    <section class="section">
        <div class="row">
            <div class="col offset-lg-1 col-lg-10">
                <div class="card">
                    <div class="card-body">
                        <h1>Liste des produits</h1>
                        <a href="<%= request.getContextPath() %>/produits/insert"><button type="button" class="btn btn-success">Insérer un nouveau prouduit</button></a>
                        <table class="table datatable">
                            <thead>
                            <tr>
                                <th scope="col"><a href="#" class="dataTable-sorter">#</a>
                                </th>
                                <th scope="col"><a href="#" class="dataTable-sorter">Nom</a>
                                </th>
                                <th scope="col"><a href="#" class="dataTable-sorter">Catégorie</a>
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                for (Produit p : produits) {
                            %>
                            <tr>
                                <th scope="row"><%= p.getIdProduit() %>
                                </th>
                                <td><%= p.getNomProduit() %>
                                </td>
                                <td><%= p.getCategorie().getLibelle() %>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>