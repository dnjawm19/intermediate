package com.example.intermediate.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDto {

  @NotEmpty
  @NotNull
  @Pattern(regexp = "^([a-z][0-9]){4,12}", message = "에러")
  private String nickname;

  @NotEmpty
  @NotNull
  @Pattern(regexp = "^([~!@#$%^&*()+|=][a-zA-Z][0-9]){8,20}", message = "에러")
  private String password;

  @NotEmpty
  @NotNull
  @Pattern(regexp = "^([~!@#$%^&*()+|=][a-zA-Z][0-9]){8,20}", message = "에러")
  private String passwordConfirm;
}
