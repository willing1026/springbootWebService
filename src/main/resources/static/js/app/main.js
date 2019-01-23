let member = {
    init: function() {
        let _this = this;
        
        $('#btn-member-register').on('click',function() {
            _this.save();
        });
        
        
        
//        $('.btn-member-delete').on('click', function() {
//            _this.delete(event);
//        });
        
        $('.btn-member-delete').on({
            'click': function() {
                _this.delete(event);
            }
        });
        
        $('.btn-member-update').on({
            'click': function () {
                _this.loadUpdateModal(event);
            }
        });
            
        
    },
    
    save: function() {
        let member = {
            userId: $('#userId').val(),
            name: $('#name').val(),
            age: $('#age').val()
        };
        
        $.ajax({
            url: '/member',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(member),
            success: function() {
                alert('success')
            },
            error: function() {
                alert('fail')
            }
        }).always(function() {
            location.reload();
        });
    },
    
    delete: function(event) {
        
        /* target : 이벤트가 전파된 마지막 요소를 가리킨다*/
        let delete_btn = $(event.target);
        let delete_user_id = delete_btn.parent().parent().children().eq(1).text();
        let delete_url="/member/"+delete_user_id;
        
        console.log("delete no : " +  delete_user_id);
        
        $.ajax({
            url: delete_url,
            type: 'DELETE',
            dataType: 'text',
            contentType: 'application/text; charset-utf-8',
            data:'',
            success: function() {
                alert('삭제');
            },
            error: function() {
                alert('실패');
            }
        }).always(function(){
            location.reload(); 
        });
    },
        
    loadUpdateModal: function(event) {
        let update_btn = $(event.target);
        let row = update_btn.parent().parent().children();
        
        let member = {
            no: row.eq(0).text(),
            userId: row.eq(1).text(),
            name: row.eq(2).text(),
            age: row.eq(3).text()
        };
        
        console.log("member.no" + member.no);
        console.log("member.userId" + member.userId);
        console.log("member.name" + member.name);
        console.log("member.age" + member.age);
                
        let updateModal = $("memberUpdateModal");
        updateModal.find('.modal-body input[id="no"]').val(member.no);
        updateModal.find('.modal-body input[id="userId"]').val(member.userId);
        updateModal.find('.modal-body input[id="name"]').val(member.name);
        updateModal.find('.modal-body input[id="age"]').val(member.age);
        
    }
}

member.init();