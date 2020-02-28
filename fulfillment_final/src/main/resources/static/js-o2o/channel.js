var contextRoot = null;

$(document).ready(function () {
    contextRoot = $('meta[name=contextRoot]').attr("content");
    if (!contextRoot)
        contextRoot = '';

    var pickr = $("#sync-date").flatpickr({
        onChange: function (dates, str, pickr) {
            reload();
        }
    });
    pickr.setDate(new Date());

    $('#sync-button').click(function (e) {
        e.preventDefault();

        updateData();
    });

    reload();
});

function updateData() {
    console.log($("#sync-date").val());

    var fd = 'area=out' + '&date_type=now' + '&airdate=' + $("#sync-date").val()
        + '&pk_epg_mapp='
        + '&fd_mapp_cd=4002'
        + '&searchColumn='
        + '&searchString='
        + '&selectString='
        + '&fd_channel_id='

    fd = 'area=out&date_type=now&airdate=2019-3-20&pk_epg_mapp=&fd_mapp_cd=&searchColumn=&searchString=&selectString=\n';
    console.log(fd + "," + fd.length);
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "https://www.skylife.co.kr/channel/epg/channelScheduleListInfo.do", false);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send(fd);
    console.log(xhttp.responseText);

    $.ajax({
        url: 'https://www.skylife.co.kr/channel/epg/channelScheduleListInfo.do',
        type: 'POST',
        data: fd,
        headers: {
            Accept: "application/json, text/javascript, */*;",
        },
        success: function (data) {
            console.log(data);
        }
    });

}

function reload() {
    $.ajax({
        url: contextRoot + '/api/1.0/channel',
        success: function (data) {
            console.log(data);
        }
    });
}
