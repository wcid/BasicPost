$.urlParam = function(name){
    const results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results==null){
        return null;
    }
    else{
        return results[1] || 0;
    }
}

const main = {
    init : function () {
        const _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function() {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },

    loadPostsPage : function () {
        $.ajax({
            type: 'GET',
            url: '/api/v1/post',
            dataType: 'json',
            contentType: 'application/json; charset=utf=8'
        }).done(function (json) {
            $('#tbl-posts tbody').empty();
            $.each(json.posts , function(idx, val) {
                let html = '';
                html += '<tr>';
                html += '<td>'+val.id+'</td>';
                html += '<td><a href="/post/update?id='+val.id+'">'+val.title+'</a></td>';
                html += '<td>'+val.writer+'</td>';
                html += '</tr>';
                $('#tbl-posts tbody').append(html);
            });
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    load : function (id) {
        $.ajax({
            type: 'GET',
            url: '/api/v1/post/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf=8'
        }).done(function (json) {
            $('#id').val(json.id);
            $('#title').val(json.title);
            $('#contents').val(json.contents);
            $('#writer').val(json.writer);
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    save : function () {
        const data = {
            title: $('#title').val(),
            writer: $('#writer').val(),
            contents: $('#contents').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/post',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('게시글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    update : function () {
        const data = {
            title: $('#title').val(),
            contents: $('#contents').val()
        };

        const id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/post/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf=8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('게시글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    delete : function () {
        const id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/post/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('게시글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();