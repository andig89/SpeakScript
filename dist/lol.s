	.section	__TEXT,__text,regular,pure_instructions
	.section	__TEXT,__literal8,8byte_literals
	.align	3
LCPI0_0:
	.quad	4607182418800017408     ## double 1
	.section	__TEXT,__text,regular,pure_instructions
	.globl	_main
	.align	4, 0x90
_main:                                  ## @main
## BB#0:
	pushq	%rbx
	subq	$2080, %rsp             ## imm = 0x820
	movl	$25, 48(%rsp)
	movl	$2, 40(%rsp)
	movl	$3, 40(%rsp)
	movl	$26, 36(%rsp)
	movl	$3, 32(%rsp)
	movabsq	$4616302208045442662, %rax ## imm = 0x4010666666666666
	movq	%rax, 16(%rsp)
	callq	_aa
	leaq	L_.scanf_string(%rip), %rdi
	leaq	1063(%rsp), %rbx
	movq	%rax, 2072(%rsp)
	movq	%rbx, %rsi
	xorb	%al, %al
	callq	_scanf
	movq	%rbx, %rdi
	callq	_IsDigital
	testb	%al, %al
	je	LBB0_4
## BB#1:
	leaq	1063(%rsp), %rdi
	callq	_atof
	movsd	%xmm0, 8(%rsp)          ## 8-byte Spill
	movsd	LCPI0_0(%rip), %xmm1
	callq	_fmod
	xorpd	%xmm1, %xmm1
	ucomisd	%xmm1, %xmm0
	jne	LBB0_3
	jp	LBB0_3
## BB#2:
	cvttsd2si	8(%rsp), %eax   ## 8-byte Folded Reload
	movl	%eax, 32(%rsp)
	movl	$1, 28(%rsp)
	jmp	LBB0_5
LBB0_4:
	leaq	54(%rsp), %rdi
	leaq	1063(%rsp), %rsi
	callq	_strcpy
	movl	$3, 28(%rsp)
	jmp	LBB0_5
LBB0_3:
	movsd	8(%rsp), %xmm0          ## 8-byte Reload
	movsd	%xmm0, 16(%rsp)
	movl	$2, 28(%rsp)
LBB0_5:
	movq	2072(%rsp), %rsi
	leaq	L_.printf_string(%rip), %rdi
	xorb	%al, %al
	callq	_printf
	movl	48(%rsp), %esi
	leaq	L_.printf_int(%rip), %rbx
	movq	%rbx, %rdi
	xorb	%al, %al
	callq	_printf
	movl	36(%rsp), %esi
	movq	%rbx, %rdi
	xorb	%al, %al
	callq	_printf
	movl	28(%rsp), %eax
	cmpl	$1, %eax
	jne	LBB0_7
## BB#6:
	movl	32(%rsp), %esi
	leaq	L_.printf_int(%rip), %rdi
	xorb	%al, %al
	callq	_printf
	jmp	LBB0_10
LBB0_7:
	cmpl	$2, %eax
	jne	LBB0_9
## BB#8:
	movsd	16(%rsp), %xmm0
	leaq	L_.printf_double(%rip), %rdi
	movb	$1, %al
	callq	_printf
	jmp	LBB0_10
LBB0_9:
	leaq	L_.printf_string(%rip), %rdi
	leaq	54(%rsp), %rsi
	xorb	%al, %al
	callq	_printf
LBB0_10:
	xorl	%eax, %eax
	addq	$2080, %rsp             ## imm = 0x820
	popq	%rbx
	ret

	.globl	_IsDigital
	.align	4, 0x90
_IsDigital:                             ## @IsDigital
## BB#0:
	subq	$24, %rsp
	movq	%rdi, 8(%rsp)
	leaq	16(%rsp), %rsi
	callq	_strtold
	fstp	%st(0)
	movq	16(%rsp), %rax
	movsbl	(%rax), %eax
	testl	%eax, %eax
	sete	%al
	addq	$24, %rsp
	ret

	.globl	_aa
	.align	4, 0x90
_aa:                                    ## @aa
## BB#0:
	movl	$4, -4(%rsp)
	movl	$27, -4(%rsp)
	leaq	L_.aa.return(%rip), %rax
	ret

	.section	__TEXT,__cstring,cstring_literals
L_.aa.return:                           ## @.aa.return
	.asciz	 "sccasdasfsdfasd "

L_.scanf_string:                        ## @.scanf_string
	.asciz	 "%s"

L_.printf_string:                       ## @.printf_string
	.asciz	 "%s \n"

L_.printf_int:                          ## @.printf_int
	.asciz	 "%i \n"

L_.printf_double:                       ## @.printf_double
	.asciz	 "%f \n"


.subsections_via_symbols
