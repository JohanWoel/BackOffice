<%@ page import="encheres.backoffice.models.statistiques.AvgMise" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<AvgMise> list = (List<AvgMise>) request.getAttribute("stat");
%>
<main id="main" class="main">
    <div class="pagetitle">
        <h1>Statistiques</h1>
        <br>
    </div>

    <section class="section">
        <div class="row">
            <div class="col offset-lg-1 col-lg-10">

                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Catégorie</th>
                                <th>Nombre de mises totales</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                for (AvgMise e : list) {
                            %>
                            <tr>
                                <td><%= e.getLibelle() %>
                                </td>
                                <td><%= e.getMoyenneMise() %>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="card">
                    <div class="card-body pb-0">
                        <h5 class="card-title">Statistiques <span>| Moyenne de mise par catégorie</span></h5>
                        <div id="trafficChart" style="min-height: 400px;" class="echart"></div>

                        <script>
                            document.addEventListener("DOMContentLoaded", () => {
                                echarts.init(document.querySelector("#trafficChart")).setOption({
                                    tooltip: {
                                        trigger: 'item'
                                    },
                                    legend: {
                                        top: '5%',
                                        left: 'center'
                                    },
                                    series: [{
                                        name: 'Access From',
                                        type: 'pie',
                                        radius: ['40%', '70%'],
                                        avoidLabelOverlap: false,
                                        label: {
                                            show: false,
                                            position: 'center'
                                        },
                                        emphasis: {
                                            label: {
                                                show: true,
                                                fontSize: '18',
                                                fontWeight: 'bold'
                                            }
                                        },
                                        labelLine: {
                                            show: false
                                        },
                                        data: [
                                            <%
                                            for (AvgMise e: list) {
                                            %>
                                            {
                                                value: <%= e.getMoyenneMise() %>,
                                                name: '<%= e.getLibelle() %>'
                                            },
                                            <%
                                                }
                                                %>
                                        ]
                                    }]
                                });
                            });
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
