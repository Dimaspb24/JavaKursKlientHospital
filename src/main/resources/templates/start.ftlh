<#import "parts/adminCommon.ftlh" as c >

<@c.page>

    <h1>Welcome to the Hospital!</h1> <br>

    <div class="form-group row">
        <form action="/login" method="GET">
            <button class="btn btn-primary" type="submit">Sign in</button>
        </form>
    </div>

    <div class="form-group row">
        <form action="/registration" method="GET">
            <button class="btn btn-primary" type="submit">Sign up</button>
        </form>
    </div>

</@c.page>
