<#import "parts/common.ftlh" as c >

<@c.page>
    <div class="form-group mt-3">

        <form method="post" accept-charset="UTF-8" action="/diagnoses/save">
            <div class="form-group col-md-6">
                <input type="hidden" name="id" class="form-control"
                       value="${diagnosis.id}" placeholder="Enter diagnosis id"/>
            </div>
            <div class="form-group col-md-6">
                <input type="text" name="name" class="form-control"
                       value="${diagnosis.name}" placeholder="Type diagnosis name"/>
            </div>
            <button type="submit" class="btn btn-primary mb-2">Save</button>
        </form>

    </div>
</@c.page>