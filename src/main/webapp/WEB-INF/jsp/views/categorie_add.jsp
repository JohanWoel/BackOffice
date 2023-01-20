<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<main id="main" class="main">
    <div class="pagetitle">
        <h1>Ajouter Categorie</h1>
    </div>

    <section class="section">
        <div class="row">
            <div class="col col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <h1 class="card-title">Entrez la nouvelle categorie</h1>
                        <form method="POST" action="${pageContext.request.contextPath}/categories/new">
                            <label for="libelle">Libellé</label>
                            <input id="libelle" class="form-control" name="libelle" type="text" placeholder="Libellé">
                            <br>
                            <input class="form-control btn-primary" type="submit" value="Ajouter">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>