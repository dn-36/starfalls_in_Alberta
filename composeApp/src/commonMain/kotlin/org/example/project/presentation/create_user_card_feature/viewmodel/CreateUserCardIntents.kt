package com.project.astranomapp.presentation.create_user_card_feature.viewmodel

sealed class CreateUserCardIntents{
    data class Create(val name:String,val age:String,val place:String
    ,val experience:String):CreateUserCardIntents()
    object Toast:CreateUserCardIntents()
}
