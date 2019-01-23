let member = {
    init: function() {
        let _this = this;
        
/*        $('.btn-register-modal').click(function() {
            _this.init_register_modal();
        })*/
        
        $('#btn-member-register').on('click',function() {
            _this.save();
        });

        $('.btn-member-delete').on({
            'click': function() {
                _this.delete(event);
            }
        });
        
        $('.btn-update-modal').on({
            'click': function () {
                alert('btn-member-update button click');
                _this.load_update_modal(event);
            }
        });
        
        $('#btn-member-update').on('click', function() {
            _this.update();
        })
    },
    
/*    init_register_modal: function() {
        let reg_modal = $('#memberRegisterModal');
    },*/
    
    save: function() {
        let member = {
            userId: $('#userId').val(),
            name: $('#name').val(),
            age: $('#age').val()
        };
        
        $.ajax({
            url: '/member',
            type: 'POST',
            dataType: 'text',
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
        
    load_update_modal: function(event) {
        let update_btn = $(event.target);
        let row_data = update_btn.parent().parent().children();
        
        let target = {
            no: row_data.eq(0).text(),
            userId: row_data.eq(1).text(),
            name: row_data.eq(2).text(),
            age: row_data.eq(3).text()
        };
        
        console.log("member.no : " + target.no);
        console.log("member.userId : " + target.userId);
        console.log("member.name : " + target.name);
        console.log("member.age : " + target.age);
                
        let update_modal = $("#memberUpdateModal");
        update_modal.find('.modal-body input[id="updateUserId"]').val(target.userId);
        update_modal.find('.modal-body input[id="updateName"]').val(target.name);
        update_modal.find('.modal-body input[id="updateAge"]').val(target.age);
        
    },
    
    update: function() {
        
        let member = {
            userId: $('#updateUserId').val(),
            name: $("#updateName").val(),
            age: $("#updateAge").val()
        }
        
        let target_url='/member/' + member.userId;
        
        $.ajax({
            url: target_url,
            type: 'PUT',
            dataType: 'text',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(member),
            success: function() {
                alert('update success');
            },
            error: function() {
                alert('fail');
            }
        }).always(function() {
            location.reload();
        })
    }
}

member.init();