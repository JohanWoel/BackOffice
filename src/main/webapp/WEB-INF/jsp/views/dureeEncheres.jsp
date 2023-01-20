<%@ page import="encheres.backoffice.models.EnchereDuree" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String indication = "";
    if(request.getAttribute("indication") != null) {
        indication = (String) request.getAttribute("indication");
    }
    List<EnchereDuree> durees = (List<EnchereDuree>) request.getAttribute("durees");
%>
<main id="main" class="main">
    <div class="pagetitle">
        <h1>Configuration durée enchère</h1>
        <br>
    </div>

    <section class="section">
        <div class="row">
            <div class="col col-lg-12">
                <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Configurer durée minimale et maximale d'une enchère</h5>
                    <form action="/durees/inserer" method="post">
                        <% for(EnchereDuree d : durees) { %>
                        <div class="row mb-3">
                            <label  class="col-sm-2 col-form-label">Minimale:</label>
                            <br/>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" name="dureeMin" value="<%= d.getDureeMin() %>">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label class="col-sm-2 col-form-label">Maximale:</label>
                            <br/>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" name="dureeMax" value="<%= d.getDureeMax() %>">
                            </div>
                        </div>
                        <% } %>
                        <%= indication %>

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