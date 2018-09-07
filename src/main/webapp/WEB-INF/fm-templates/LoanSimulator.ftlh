<!DOCTYPE html>
<html>
<body>
<h1>Wpisz dane kredytu.</h1>
Uwaga: program zakłada, że raty są równe a oprocentowanie nie zmienia się w czasie.
<form method="POST" target="_blank" action="/loanSimulator">
    Kwota kredytu: <input type="text" name="loan"/><br/><br/>
    Okres kredytowania (w miesiącach): <input type="text" name="months"/><br/><br/>
    Marża banku (w procentach): <input type="text" name="profit"/><br/><br/>
    Prowizja banku (w procentach): <input type="text" name="commission"/><br/><br/>
    <input type="submit" name="save" value="save"/><br/>
    <input type="reset" name="reset" value="clear"/></br>

    <table style="width:100%">
        RRSO:
        Całkowity koszt kredytu (kapitał + odsetki):
        <tr>
            <th>Numer miesiąca</th>
            <th>Kwota raty</th>
            <th>Kwota pozostała do spłaty</th>
        </tr>
        <tr>
            <td>aaaa</td>
            <td>bbbb</td>
            <td>cccc</td>
        </tr>
    </table>


</form>
</body>
</html>