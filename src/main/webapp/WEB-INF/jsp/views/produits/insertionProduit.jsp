<%@ page import="encheres.backoffice.models.EnchereDuree" %>
<%@ page import="java.util.List" %>
<%@ page import="encheres.backoffice.models.Categorie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Categorie> lc = (List<Categorie>) request.getAttribute("categories");
%>
<main id="main" class="main">
    <div class="pagetitle">
        <h1>Insertion produit</h1>
        <br>
    </div>

    <section class="section">
        <div class="row">
            <div class="col col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Insérer nouveau produit</h5>
                        <form action="<%= request.getContextPath() %>/produits" method="post">
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Catégorie: </label>
                                <div class="col-sm-10">
                                    <select class="form-select" aria-label="Default select example" name="idCategorie">
                                        <% for(Categorie c: lc) { %>
                                        <option value="<%= c.getIdCategorie() %>"><%= c.getLibelle() %></option>
                                        <% } %>
                                    </select>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">Produit: </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="nomProduit">
                                </div>
                            </div>

                            <div class="row mb-3">
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-primary">Configurer</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>