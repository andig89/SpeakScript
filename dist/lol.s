	.section	__TEXT,__text,regular,pure_instructions
	.globl	_main
	.align	4, 0x90
_main:                                  ## @main
## BB#0:
	pushq	%rbx
	subq	$16, %rsp
	movl	$25, 12(%rsp)
	movl	$24, 4(%rsp)
	leaq	L_.format_str(%rip), %rdi
	leaq	8(%rsp), %rsi
	xorb	%al, %al
	callq	_scanf
	movl	8(%rsp), %esi
	leaq	L_.format_str1(%rip), %rbx
	movq	%rbx, %rdi
	xorb	%al, %al
	callq	_printf
	movl	12(%rsp), %esi
	movq	%rbx, %rdi
	xorb	%al, %al
	callq	_printf
	movl	4(%rsp), %esi
	movq	%rbx, %rdi
	xorb	%al, %al
	callq	_printf
	xorl	%eax, %eax
	addq	$16, %rsp
	popq	%rbx
	ret

	.section	__TEXT,__cstring,cstring_literals
L_.format_str1:                         ## @.format_str1
	.asciz	 "%i \n"

L_.format_str:                          ## @.format_str
	.asciz	 "%i"


.subsections_via_symbols
