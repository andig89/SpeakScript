	.section	__TEXT,__text,regular,pure_instructions
	.globl	_main
	.align	4, 0x90
_main:                                  ## @main
## BB#0:
	pushq	%rbx
	subq	$16, %rsp
	movl	$23, 12(%rsp)
	leaq	L_.format_str(%rip), %rbx
	movq	%rbx, %rdi
	movl	$23, %esi
	xorb	%al, %al
	callq	_printf
	movl	$2, 8(%rsp)
	movq	%rbx, %rdi
	movl	$2, %esi
	xorb	%al, %al
	callq	_printf
	xorl	%eax, %eax
	addq	$16, %rsp
	popq	%rbx
	ret

	.section	__TEXT,__cstring,cstring_literals
L_.format_str:                          ## @.format_str
	.asciz	 "%d\n"


.subsections_via_symbols
