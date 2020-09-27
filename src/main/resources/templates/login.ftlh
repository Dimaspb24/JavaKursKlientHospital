<#import "parts/common.ftlh" as c >
<#import "parts/login.ftlh" as l>

<@c.page>

    <h2 class="form-signin-heading">Login</h2>

    <@l.login "/auth/login" />

    <div class="form-group row mt-3 ml-1">
        <form action="/registration" method="GET">
            <button class="btn btn-secondary btn-sm" type="submit">Sign up</button>
        </form>
    </div>
</@c.page>