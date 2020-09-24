<#import "parts/common.ftlh" as c >

<@c.page>
    Start diagnoses
    <div>

        <div>
            <a href="/auth/main" methods="get"> Главная страница </a>
        </div>

        <#--        Создать диагноз -->
        <form method="post" accept-charset="UTF-8" action="/diagnoses/save">
            <input type="text" name="name" placeholder="Введите новое имя"/>
            <button type="submit">Добавить</button>
        </form>

        <#--        Найти диагноз -->
        <form method="get" action="/diagnoses">
            <input type="text" name="filter" placeholder="Введите имя диагноза" value="${filter!}">
            <button type="submit">Найти</button>
        </form>

        <#--        Удалить диагноз -->
<#--        <form method="post" action="/diagnoses">-->
<#--            <input type="text" name="name" placeholder="Введите имя диагноза" value="">-->
<#--            <button type="submit">Удалить</button>-->
<#--        </form>-->


        <#--        Изменить диагноз -->
<#--        <form method="get" action="/diagnoses">-->
<#--            <input type="text" name="Old name" placeholder="Старое имя" value="">-->
<#--            <input type="text" name="New name" placeholder="Новое имя" value="">-->

<#--            <button type="submit">Изменить</button>-->
<#--        </form>-->

    </div>

<#--    Получить все диагнозы -->
    <h3>Список диагнозов</h3>

    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>

            <#list diagnosesList as diagnosis>
                <tr>
                    <td>${diagnosis.id}
                    <td>${diagnosis.name}
<#--                    <td><a href="/diagnoses/${diagnosis.id}"> Edit </a>-->
<#--                    <td><a href="/diagnoses/${diagnosis.id}"> Delete </a>-->
                </tr>
            </#list>

        </tbody>
    </table>



</@c.page>