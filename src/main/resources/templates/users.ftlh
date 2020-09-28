<#import "parts/adminCommon.ftlh" as c >

<@c.page>

    <a class="btn btn-primary mb-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Add user
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">

            <form name="form" action="/users" method="post" accept-charset="UTF-8">
                <div class="form-group mb-3">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text mr-2">Email</span>
                        </div>
                        <input type="text" name="email" class="form-control"
                               placeholder="Enter mail">
                    </div>
                </div>

                <div class="form-group mb-3">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text mr-2">Password</span>
                        </div>
                        <input type="password" name="password" class="form-control" placeholder="Enter password">
                    </div>
                </div>

                <div class="form-group mb-3">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">First and last name</span>
                        </div>
                        <input type="text" name="firstName" class="form-control" placeholder="Enter first name">
                        <input type="text" name="lastName" class="form-control" placeholder="Enter last name">
                    </div>
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">Role</label>
                    </div>
                    <select class="custom-select" id="inputGroupSelect01" name="role">
                        <option selected value="USER">USER</option>
                        <option value="ADMIN">ADMIN</option>
                    </select>
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">Status</label>
                    </div>
                    <select class="custom-select" id="inputGroupSelect01" name="status">
                        <option selected value="ACTIVE">ACTIVE</option>
                        <option value="BANNED">BANNED</option>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary mb-3">Save</button>
            </form>
        </div>
    </div>

    <h2> Users </h2>

    <table class="table table-bordered table-hover table-sm mt-2">
        <thead class="thead-light">
        <tr>
            <th scope="col">№</th>
            <th scope="col">Email</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Role</th>
            <th scope="col">Status</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.id}
                <td>${user.email}
                <td>${user.firstName}
                <td>${user.lastName}
                <td>${user.role}
                <td>${user.status}
                <td>
                    <form method="get" action="/users/${user.email}">
                        <button class="btn btn-outline-secondary" type="submit">Edit</button>
                    </form>
                <td>
                    <form method="post" action="/users/${user.id}">
                        <button class="btn btn-outline-secondary" type="submit">Delete</button>
                    </form>
            </tr>
        </#list>
        </tbody>
    </table>

</@c.page>