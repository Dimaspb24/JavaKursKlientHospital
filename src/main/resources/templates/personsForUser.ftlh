<#import "parts/userCommon.ftlh" as c >

<@c.page>
    <div>
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
            </tr>
        </#list>

        </tbody>
    </table>

</@c.page>