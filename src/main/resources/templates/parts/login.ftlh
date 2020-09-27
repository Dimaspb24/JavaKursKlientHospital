<#--"/auth/login"-->
<#macro login path>
    <form class="form-signin" action="${path}" method="post">

        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="email">Email</label>
            <div class="col-sm-5">
                <input type="text" id="email" name="email" class="form-control" placeholder="Email" required>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="password">Password</label>
            <div class="col-sm-5">
                <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                       required>
            </div>
        </div>

        <button class="btn btn-primary" type="submit">Sign in</button>

    </form>
</#macro>

<#macro logout path>
    <div>
        <form action="/auth/logout" method="post">
            <button class="btn btn-primary" type="submit">Sign Out</button>
        </form>
    </div>
</#macro>