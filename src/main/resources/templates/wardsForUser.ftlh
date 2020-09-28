<#import "parts/userCommon.ftlh" as c >

<@c.page>
    <div>
        <#--        Найти палату -->
        <form method="get" action="/wards">
            <div class="input-group mb-3 mt-3">
                <input type="text" name="filter" class="form-control"
                       placeholder="Enter ward name" value="${filter!}">
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">Search</button>
                </div>
            </div>
        </form>

    </div>

<#--    Получить все палаты -->
    <h3>List of wards</h3>

    <table class="table table-bordered table-hover table-sm">
        <thead class="thead-light">
        <tr>
            <th scope="col">№</th>
            <th scope="col">Name</th>
            <th scope="col">Max count</th>
        </tr>
        </thead>
        <tbody>

        <#list wards as ward>
            <tr>
                <td>${ward.id}
                <td>${ward.name}
                <td>${ward.maxCount}
            </tr>
        </#list>

        </tbody>
    </table>

</@c.page>