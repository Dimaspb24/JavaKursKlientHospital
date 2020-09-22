<#--"/auth/login"-->
<#macro login path>
    <form class="form-signin" action="${path}" method="post">
        <h2 class="form-signin-heading">Login</h2>
        <p><label for="email">Email</label>
            <input type="text" id="email" name="email" class="form-control" placeholder="Email" required></p>
        <p><label for="password">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required></p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</#macro>

<#macro logout path>
    <div>
        <form action="/auth/logout" method="post">
            <input type="submit" value="Sign Out"/>
        </form>
    </div>
</#macro>