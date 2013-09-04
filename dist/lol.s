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
	subq	$3088, %rsp             ## imm = 0xC10
	movl	$12, 56(%rsp)
	movl	$2, 52(%rsp)
	movl	$1, 52(%rsp)
	movl	$26, 48(%rsp)
	movl	$3, 44(%rsp)
	movabsq	$4616302208045442662, %rax ## imm = 0x4010666666666666
	movq	%rax, 32(%rsp)
	leaq	L_.scanf_string(%rip), %rdi
	leaq	2079(%rsp), %rbx
	movq	%rbx, %rsi
	xorb	%al, %al
	callq	_scanf
	movq	%rbx, %rdi
	callq	_IsDigital
	testb	%al, %al
	je	LBB0_4
## BB#1:
	leaq	2079(%rsp), %rdi
	callq	_atof
	vmovsd	%xmm0, 8(%rsp)          ## 8-byte Spill
	vmovsd	LCPI0_0(%rip), %xmm1
	callq	_fmod
	vxorpd	%xmm1, %xmm1, %xmm1
	vucomisd	%xmm1, %xmm0
	jne	LBB0_3
	jp	LBB0_3
## BB#2:
	vcvttsd2si	8(%rsp), %eax   ## 8-byte Folded Reload
	movl	%eax, 52(%rsp)
	movl	$1, 28(%rsp)
	jmp	LBB0_5
LBB0_4:
	leaq	1070(%rsp), %rdi
	leaq	2079(%rsp), %rsi
	callq	_strcpy
	movl	$3, 28(%rsp)
	jmp	LBB0_5
LBB0_3:
	vmovsd	8(%rsp), %xmm0          ## 8-byte Reload
	vmovsd	%xmm0, 16(%rsp)
	movl	$2, 28(%rsp)
LBB0_5:
	leaq	L_.scanf_string(%rip), %rdi
	leaq	2079(%rsp), %rbx
	movq	%rbx, %rsi
	xorb	%al, %al
	callq	_scanf
	movq	%rbx, %rdi
	callq	_IsDigital
	testb	%al, %al
	je	LBB0_9
## BB#6:
	leaq	2079(%rsp), %rdi
	callq	_atof
	vmovsd	%xmm0, 8(%rsp)          ## 8-byte Spill
	vmovsd	LCPI0_0(%rip), %xmm1
	callq	_fmod
	vxorpd	%xmm1, %xmm1, %xmm1
	vucomisd	%xmm1, %xmm0
	jne	LBB0_8
	jp	LBB0_8
## BB#7:
	vcvttsd2si	8(%rsp), %eax   ## 8-byte Folded Reload
	movl	%eax, 44(%rsp)
	movl	$1, 24(%rsp)
	jmp	LBB0_10
LBB0_9:
	leaq	61(%rsp), %rdi
	leaq	2079(%rsp), %rsi
	callq	_strcpy
	movl	$3, 24(%rsp)
	jmp	LBB0_10
LBB0_8:
	vmovsd	8(%rsp), %xmm0          ## 8-byte Reload
	vmovsd	%xmm0, 32(%rsp)
	movl	$2, 24(%rsp)
LBB0_10:
	movl	28(%rsp), %eax
	cmpl	$1, %eax
	jne	LBB0_12
## BB#11:
	movl	52(%rsp), %esi
	leaq	L_.printf_int(%rip), %rdi
	xorb	%al, %al
	callq	_printf
	jmp	LBB0_15
LBB0_12:
	cmpl	$2, %eax
	jne	LBB0_14
## BB#13:
	vmovsd	16(%rsp), %xmm0
	leaq	L_.printf_double(%rip), %rdi
	movb	$1, %al
	callq	_printf
	jmp	LBB0_15
LBB0_14:
	leaq	L_.printf_string(%rip), %rdi
	leaq	1070(%rsp), %rsi
	xorb	%al, %al
	callq	_printf
LBB0_15:
	movl	56(%rsp), %esi
	leaq	L_.printf_int(%rip), %rbx
	movq	%rbx, %rdi
	xorb	%al, %al
	callq	_printf
	movl	48(%rsp), %esi
	movq	%rbx, %rdi
	xorb	%al, %al
	callq	_printf
	leaq	L_.scanf_string(%rip), %rdi
	leaq	2079(%rsp), %rbx
	movq	%rbx, %rsi
	xorb	%al, %al
	callq	_scanf
	movq	%rbx, %rdi
	callq	_IsDigital
	testb	%al, %al
	je	LBB0_19
## BB#16:
	leaq	2079(%rsp), %rdi
	callq	_atof
	vmovsd	%xmm0, 8(%rsp)          ## 8-byte Spill
	vmovsd	LCPI0_0(%rip), %xmm1
	callq	_fmod
	vxorpd	%xmm1, %xmm1, %xmm1
	vucomisd	%xmm1, %xmm0
	jne	LBB0_18
	jp	LBB0_18
## BB#17:
	vcvttsd2si	8(%rsp), %eax   ## 8-byte Folded Reload
	movl	%eax, 44(%rsp)
	movl	$1, 24(%rsp)
	jmp	LBB0_20
LBB0_19:
	leaq	61(%rsp), %rdi
	leaq	2079(%rsp), %rsi
	callq	_strcpy
	movl	$3, 24(%rsp)
	jmp	LBB0_20
LBB0_18:
	vmovsd	8(%rsp), %xmm0          ## 8-byte Reload
	vmovsd	%xmm0, 32(%rsp)
	movl	$2, 24(%rsp)
LBB0_20:
	movl	24(%rsp), %eax
	cmpl	$1, %eax
	jne	LBB0_22
## BB#21:
	movl	44(%rsp), %esi
	leaq	L_.printf_int(%rip), %rdi
	xorb	%al, %al
	callq	_printf
	jmp	LBB0_25
LBB0_22:
	cmpl	$2, %eax
	jne	LBB0_24
## BB#23:
	vmovsd	32(%rsp), %xmm0
	leaq	L_.printf_double(%rip), %rdi
	movb	$1, %al
	callq	_printf
	jmp	LBB0_25
LBB0_24:
	leaq	L_.printf_string(%rip), %rdi
	leaq	61(%rsp), %rsi
	xorb	%al, %al
	callq	_printf
LBB0_25:
	xorl	%eax, %eax
	addq	$3088, %rsp             ## imm = 0xC10
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

	.section	__TEXT,__cstring,cstring_literals
L_.scanf_string:                        ## @.scanf_string
	.asciz	 "%s"

L_.printf_int:                          ## @.printf_int
	.asciz	 "%i \n"

L_.printf_double:                       ## @.printf_double
	.asciz	 "%f \n"

L_.printf_string:                       ## @.printf_string
	.asciz	 "%s \n"


.subsections_via_symbols
