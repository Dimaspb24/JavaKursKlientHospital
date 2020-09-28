<#import "parts/adminCommon.ftlh" as c >

<@c.page>
    <div class="form-group mt-3">

        <form method="post" accept-charset="UTF-8" action="/persons/save">
            <div class="form-group col-md-6">
                <input type="hidden" name="id" class="form-control"
                       value="${person.id}" placeholder="Enter id"/>
            </div>
            <div class="form-group mb-3">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Full name</span>
                    </div>
                    <input type="text" name="lastName" value="${person.lastName}" class="form-control"
                           placeholder="Enter last name"/>
                    <input type="text" name="firstName" value="${person.firstName}" class="form-control"
                           placeholder="Enter first name"/>
                    <input type="text" name="patherName" value="${person.patherName}" class="form-control"
                           placeholder="Enter patronymic"/>
                </div>
            </div>
            <div class="form-group col-md-6">
                <input type="text" name="diagnosisName" value="${person.diagnosisName}" class="form-control"
                       placeholder="Enter diagnosis"/>
            </div>
            <div class="form-group col-md-6">
                <input type="text" name="wardName" value="${person.wardName}" class="form-control"
                       placeholder="Enter ward"/>
            </div>

            <button type="submit" class="btn btn-primary mb-2">Save</button>
        </form>

    </div>
</@c.page>