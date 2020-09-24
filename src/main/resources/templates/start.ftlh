<#import "parts/common.ftlh" as c >

<@c.page>

        <h1>Welcome to the Start page!</h1>

        <form action="/login" method="GET">
            <button type="submit">Sign In</button>
        </form>

        <form action="/registration" method="GET">
            <button type="submit">Sign Up</button>
        </form>

</@c.page>
