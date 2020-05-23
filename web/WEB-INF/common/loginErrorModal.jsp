<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 23/05/2020
  Time: 03:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Error Login Modal-->
<div class="modal fade" id="loginErrorModal" tabindex="-1" role="dialog" aria-labelledby="loginErrorLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="loginErrorLabel">Mot de passe éronné !</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Retenter de vous reconnecter avec votre pseudo et mot de passe.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Ok</button>
            </div>
        </div>
    </div>
</div>
<!-- End of Error Login Modal -->
