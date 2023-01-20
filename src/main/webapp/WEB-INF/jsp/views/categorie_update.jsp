<%@ page import="encheres.backoffice.models.Categorie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Categorie categorie = (Categorie) request.getAttribute("categorie");
%>

<main id="main" class="main">
    <div class="pagetitle">
        <h1>Modifier Categorie</h1>
    </div>

    <section class="section">
        <div class="row">
            <div class="col col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <h1 class="card-title">Modification</h1>
                        <form id="form" method="post" action="<%= request.getContextPath() %>/categories">
                            <input type="hidden" name="idCategorie" value="<%= categorie.getIdCategorie() %>">
                            <label for="libelle">Libellé</label>
                            <input id="libelle" class="form-control" name="libelle" type="text" value="<% out.print(categorie.getLibelle()); %>">
                            <br>
                            <input class="form-control btn-primary" type="submit" value="Modifier" <%--onclick="put()"--%>>
                            <hr>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<script src="./../../../assets/js/jquery-3.6.0.min.js"></script>
<script>

    const id = "<% out.print(categorie.getIdCategorie()); %>";
    const context_path="<%= request.getContextPath() %>";
    const libelle=document.getElementById("libelle");
    const form=document.getElementById("form");

    // form.addEventListener("submit",(e)=>{
    //     e.preventDefault();
    //     put();
    // });

    async function put() {
        var data={
            "idCategorie":id,
            "libelle":libelle.value
        };
        console.log(data);
        // await fetch(context_path+"/categories/"+ id ,{
        //     method:"PUT",
        // })
        //     .then(data=> {
        //         console.log(data);
        //         console.log(context_path+"/categories/"+ id);
        //         // window.location.href = context_path+"/categories"
        //     })
        //     .catch(err=>console.log(err));
        $.ajax({
            type: 'PUT',
            url: context_path+'/categories/'+id+'/libelle/'+libelle.value,
            contentType: 'application/json',
            // data: JSON.stringify(data), // access in body
        }).done(function () {
            console.log('SUCCESS');
        }).fail(function (msg) {
            console.log('FAIL');
            console.log(msg)
        }).always(function (msg) {
            console.log('ALWAYS');
        });
    }

    async function del() {
        await fetch(context_path+"/categories/"+ id ,{
            method:"DELETE",
        })
            .then(data=> {
                console.log(data);
                window.location.href = context_path+"/categories"
            })
            .catch(err=>console.log(err));
    }
</script>