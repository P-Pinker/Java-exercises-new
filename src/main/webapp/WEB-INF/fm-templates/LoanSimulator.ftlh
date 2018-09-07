<!DOCTYPE html>
<html>
<body>
<h1>Wpisz dane kredytu.</h1>

Uwaga: program zakłada, że raty są równe a oprocentowanie nie zmienia się w czasie.

<form method="POST" target="_blank" action="/loanSimulator">
    Kwota kredytu: <input type="text" name="loan" required/><br/><br/>
    Okres kredytowania (w miesiącach): <input type="text" name="months" required/><br/><br/>
    Marża banku (w procentach): <input type="text" name="profit" required/><br/><br/>
    Prowizja banku (w procentach): <input type="text" name="markup" required/><br/><br/>
    <input type="submit" name="save" value="save"/><br/>
    <input type="reset" name="reset" value="clear"/>
</form>

    <#if ARP??>
        RRSO: ${ARP}
    <#else>
        RRSO: brak danych
    </#if>

    <#if totalCostOfCredit??>
        Całkowity koszt kredytu (kapitał + odsetki): ${totalCostOfCredit}
    <#else>
        Całkowity koszt kredytu (kapitał + odsetki): brak danych
    </#if>

    <table style="width:100%">
        <tr>
            <th>Numer miesiąca</th>
            <th>Kwota raty</th>
            <th>Kwota pozostała do spłaty</th>
        </tr>
        <#if months??>
        <tr>
            <#list months as month>
                <td>${month}</td>
            </#list>
                <td>${rate}</td>
            <#list remainingMoneyToPayback as loanLeft>
                <td>${loanLeft}</td>
            </#list>
        </tr>
        </#if>
    </table>

</body>
</html>