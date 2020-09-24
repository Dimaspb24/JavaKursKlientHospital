<#import "parts/common.ftlh" as c >
<#import "parts/login.ftlh" as l>

<@c.page>
    <h2 class="form-signin-heading">Login</h2>
    <@l.login "/auth/login" />
</@c.page>