<#import "parts/common.ftlh" as c >

<@c.page>
    <div>

        <#--        Создать палату -->
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button"
           aria-expanded="false" aria-controls="collapseExample">
            Add ward
        </a>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">

                <form method="post" accept-charset="UTF-8" action="/wards/save">
                    <div class="form-group col-md-6">
                        <input type="text" name="name" class="form-control" placeholder="Enter the name of the ward"/>
                    </div>
                    <div class="form-group col-md-6">
                        <input type="text" name="maxCount" class="form-control"
                               placeholder="Enter the number of places"/>
                    </div>

                    <button type="submit" class="btn btn-primary mb-2">Save</button>
                </form>

            </div>
        </div>


        <#--        Найти палату -->
        <form method="get" action="/wards">
            <div class="input-group mb-3 mt-3">
                <input type="text" name="filter" class="form-control"
                       placeholder="Введите имя палаты" value="${filter!}">
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
                <td>
                    <form method="get" action="/wards/${ward.id}">
                        <button class="btn btn-outline-secondary" type="submit">Edit</button>
                    </form>
                <td>
                    <form method="post" action="/wards/${ward.id}">
                        <button class="btn btn-outline-secondary" type="submit">Delete</button>
                    </form>
            </tr>
        </#list>

        </tbody>
    </table>

</@c.page>