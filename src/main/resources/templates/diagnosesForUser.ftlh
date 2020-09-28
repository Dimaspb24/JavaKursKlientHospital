<#import "parts/userCommon.ftlh" as c >

<@c.page>
    <div>
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
            </tr>
        </#list>

        </tbody>
    </table>

</@c.page>