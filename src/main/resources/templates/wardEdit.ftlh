<#import "parts/common.ftlh" as c >

<@c.page>
    <div class="form-group mt-3">

        <form method="post" accept-charset="UTF-8" action="/wards/save">


            <div class="form-group col-md-6">
                <input type="hidden" name="id" class="form-control"
                       value="${ward.id}" placeholder="Enter id"/>
            </div>
            <div class="form-group col-md-6">
                <input type="text" name="name" class="form-control"
                       value="${ward.name}" placeholder="Enter the name of the ward"/>
            </div>
            <div class="form-group col-md-6">
                <input type="text" name="maxCount" class="form-control"
                       value="${ward.maxCount}" placeholder="Enter the number of places"/>
            </div>
            <button type="submit" class="btn btn-primary mb-2">Save</button>
        </form>

    </div>
</@c.page>