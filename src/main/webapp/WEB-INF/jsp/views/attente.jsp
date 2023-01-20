<%@ page import="encheres.backoffice.models.Solde" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Solde> attentes = (List<Solde>) request.getAttribute("attentes");
%>
<main id="main" class="main">
    <div class="pagetitle">
        <h1>Validation rechargement</h1>
        <br>
    </div>

    <section class="section">
        <div class="row">
            <div class="col col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h1 class="card-title">Valider les rechargements</h1>
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Prénom(s)</th>
                                <th>Montant</th>
                                <th>Date du depot</th>
                                <th></th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                for (Solde s : attentes) {
                            %>
                            <tr>
                                <td><%= s.getUtilisateur().getNom() %></td>
                                <td><%= s.getUtilisateur().getPrenoms() %></td>
                                <td><%= s.getMontant() %> Ar</td>
                                <td><%= s.getDateDepot() %></td>
                                <td>
                                    <button type="button" id="validate_<%= s.getIdSolde() %>"
                                            class="btn btn-success rounded-pill"
                                            onclick="validate(<%= s.getIdSolde() %>,this)">Valider
                                    </button>
                                </td>
                                <td>
                                    <button type="button" id="refuse_<%= s.getIdSolde() %>"
                                            class="btn btn-danger rounded-pill" onclick="refuse(<%= s.getIdSolde() %>,this)">Refuser
                                    </button>
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
<script src="./../../assets/js/solde/validation.js"></script>