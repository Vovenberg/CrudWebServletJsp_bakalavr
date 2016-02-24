/**
 * Created by Vladimir on 24.02.2016.
 */
function choiceOnChanged(changeble){
    var params;
    if(changeble == document.getElementById('choice'))
        params = 'ttype='+document.getElementById('choice').value;
    else
        params = 'ttype='+document.getElementById('choice').value + '&orderby='+document.getElementById('order').value+'&ordertype='+document.getElementById('ordertype').value;
    window.open('add.jsp?'+params, '_self');
}