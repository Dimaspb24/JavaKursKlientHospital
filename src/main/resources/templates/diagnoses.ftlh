<#import "parts/adminCommon.ftlh" as c >

<@c.page>
    <div>

        <#--        Создать диагноз -->
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button"
           aria-expanded="false" aria-controls="collapseExample">
            Add diagnosis
        </a>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">

                <form method="post" accept-charset="UTF-8" action="/diagnoses/save">
                    <div class="form-group col-md-6">
                        <input type="text" name="name" class="form-control" placeholder="Enter diagnosis name"/>
                    </div>
                    <button type="submit" class="btn btn-primary mb-2">Save</button>
                </form>

            </div>
        </div>

        <#--        Найти диагноз -->
        <form method="get" action="/diagnoses">
            <div class="input-group mb-3 mt-3">
                <input type="text" name="filter" class="form-control" placeholder="Enter diagnosis name"
                       value="${filter!}">
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">Search</button>
                </div>
            </div>
        </form>

    </div>

    <h3>List of diagnoses</h3>

    <table class="table table-bordered table-hover table-sm">
        <thead class="thead-light">
        <tr>
            <th scope="col">№</th>
            <th scope="col">Diagnosis name</th>
        </tr>
        </thead>
        <tbody>

        <#list diagnoses as diagnosis>
            <tr>
                <td>${diagnosis.id}
                <td>${diagnosis.name}
                <td>
                    <form method="get" action="/diagnoses/${diagnosis.id}">
                        <button class="btn btn-outline-secondary" type="submit">Edit</button>
                    </form>
                <td>
                    <form method="post" action="/diagnoses/${diagnosis.id}">
                        <button class="btn btn-outline-secondary" type="submit">Delete</button>
                    </form>
            </tr>
        </#list>

        </tbody>
    </table>



</@c.page>