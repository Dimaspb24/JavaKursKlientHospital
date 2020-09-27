<#import "parts/common.ftlh" as c >

<@c.page>
    <form name="form" action="/users" method="post" accept-charset="UTF-8">
        <div class="form-group mb-3">
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text mr-2">Email</span>
                </div>
                <input type="text" name="email" readonly value="${user.email}" class="form-control">
            </div>
        </div>

        <div class="form-group mb-3">
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text mr-2">Password</span>
                </div>
                <input type="password" name="password" class="form-control" placeholder="Enter new password">
            </div>
        </div>

        <div class="form-group mb-3">
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">First and last name</span>
                </div>
                <input type="text" name="firstName" value="${user.firstName}" class="form-control"
                       placeholder="Enter first name">
                <input type="text" name="lastName" value="${user.lastName}" class="form-control"
                       placeholder="Enter last name">
            </div>
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">Role</label>
            </div>
            <select name="role" class="custom-select" id="inputGroupSelect01">
                <option selected value="${user.role}">${user.role}</option>
                <option value="1">USER</option>
                <option value="2">ADMIN</option>
                <#--                <#if "${user.role}"?seq_contains('ADMIN')>-->
                <#--                    <option value="1">USER</option>-->
                <#--                <#else>-->
                <#--                    <option value="1">ADMIN</option>-->
                <#--                </#if>-->
            </select>
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">Status</label>
            </div>
            <select name="status" class="custom-select" id="inputGroupSelect01">
                <option selected value="${user.status}">${user.status}</option>
                <option value="1">ACTIVE</option>
                <option value="2">BANNED</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary mb-2">Save</button>
    </form>

</@c.page>