<#import "parts/common.ftlh" as c >

<@c.page>
    <div>

        <#--        Создать пациента -->
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
           aria-controls="collapseExample">
            Add patient
        </a>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">

                <form method="post" accept-charset="UTF-8" action="/persons/save">
                    <div class="form-group mb-3">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Full name</span>
                            </div>
                            <input type="text" name="lastName" class="form-control" placeholder="Enter last name"/>
                            <input type="text" name="firstName" class="form-control" placeholder="Enter first name"/>
                            <input type="text" name="patherName" class="form-control" placeholder="Enter patronymic"/>
                        </div>
                    </div>

                    <div class="form-group col-md-6">
                        <input type="text" name="diagnosisName" class="form-control" placeholder="Enter diagnosis"/>
                    </div>
                    <div class="form-group col-md-6">
                        <input type="text" name="wardName" class="form-control" placeholder="Enter ward"/>
                    </div>

                    <button type="submit" class="btn btn-primary mb-2">Save</button>
                </form>
            </div>
        </div>

        <#--        Найти пациента -->
        <form method="get" action="/persons">
            <div class="input-group mb-3 mt-3">
                <input type="text" name="filter" class="form-control"
                       placeholder="Enter either first name or last name or patronymic" value="${filter!}">
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">Search</button>
                </div>
            </div>
        </form>

    </div>

<#--    Получить всех пациентов -->
    <h3>List of patients</h3>

    <table class="table table-bordered table-hover table-sm">
        <thead class="thead-light">
        <tr>
            <th scope="col">№</th>
            <th scope="col">First name</th>
            <th scope="col">Last name</th>
            <th scope="col">patronymic</th>
            <th scope="col">Diagnosis name</th>
            <th scope="col">Ward name</th>
        </tr>
        </thead>
        <tbody>

        <#list persons as person>
            <tr>
                <td>${person.id}
                <td>${person.firstName}
                <td>${person.lastName}
                <td>${person.patherName}
                <td>${person.diagnosisName}
                <td>${person.wardName}
                <td>
                    <form method="get" action="/persons/${person.id}">
                        <button class="btn btn-outline-secondary" type="submit">Edit</button>
                    </form>
                <td>
                    <form method="post" action="/persons/${person.id}">
                        <button class="btn btn-outline-secondary" type="submit">Delete</button>
                    </form>
            </tr>
        </#list>

        </tbody>
    </table>

</@c.page>