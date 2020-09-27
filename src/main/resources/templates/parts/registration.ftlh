<#--/auth/registration-->
<#macro registration path>
    <form action="${path}" method="post">

        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="email">Email</label>
            <div class="col-sm-5">
                <input type="text" id="email" name="email" class="form-control" placeholder="Email" required>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="email">Password</label>
            <div class="col-sm-5">
                <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                       required>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="firstName">First name</label>
            <div class="col-sm-5">
                <input type="text" id="firstName" name="firstName" class="form-control" placeholder="First name"
                       required>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="lastName">Last name</label>
            <div class="col-sm-5">
                <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Last name" required>
            </div>
        </div>

        <button class="btn btn-primary" type="submit">Create</button>
    </form>
</#macro>