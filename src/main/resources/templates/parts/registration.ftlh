<#--/auth/registration-->
<#macro registration path>
    <form action="${path}" method="post">
        <div><label> Email : <input type="text" name="email"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><label> First name: <input type="text" name="firstName"/> </label></div>
        <div><label> Last name: <input type="text" name="lastName"/> </label></div>
        <div><input type="submit" value="Create"/></div>
    </form>
</#macro>