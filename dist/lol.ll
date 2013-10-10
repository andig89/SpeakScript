@.aa.return = private unnamed_addr constant [17 x i8] c"sccasdasfsdfasd \00", align 1
@.scanf_string = private unnamed_addr constant [3 x i8] c"%s\00", align 1
@.printf_string = private unnamed_addr constant [5 x i8] c"%s \0A\00", align 1
@.printf_int = private unnamed_addr constant [5 x i8] c"%i \0A\00", align 1
@.printf_double = private unnamed_addr constant [5 x i8] c"%f \0A\00", align 1



define i32 @main() nounwind {
%a.string = alloca i8*, align 8
%scanf.string = alloca [1009 x i8], align 1
%d.string = alloca [1009 x i8], align 1
%b.int = alloca i32, align 4
%z.int = alloca i32, align 4
%a.int = alloca i32, align 4
%c.int = alloca i32, align 4
%d.int = alloca i32, align 4
%d.type = alloca i32, align 4
%d.double = alloca double, align 8
store i32 25, i32* %b.int, align 4
store i32 2, i32* %a.int, align 4
store i32 3, i32* %a.int, align 4
store i32 26, i32* %c.int, align 4
store i32 3, i32* %d.int, align 4
store double 4.1, double* %d.double, align 8
%1 = call i8* @aa()
store i8* %1, i8** %a.string, align 1
%2 = getelementptr inbounds [1009 x i8]* %scanf.string, i32 0, i32 0
%3 = call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([3 x i8]* @.scanf_string, i32 0, i32 0), i8* %2)
%4 = getelementptr inbounds [1009 x i8]* %scanf.string, i32 0, i32 0
%5 = call zeroext i1 @IsDigital(i8* %4)
br i1 %5, label %6, label %13

; <label>:6
%7 = call double @atof(i8* %4)
%8 = call double @fmod(double %7, double 1.000000e+00)
%9 = fcmp oeq double %8, 0.000000e+00
br i1 %9, label %10, label %12

; <label>:10
%11 = fptosi double %7 to i32
store i32 %11, i32* %d.int, align 4
store i32 1, i32* %d.type, align 4
br label %16

; <label>:12
store double %7, double* %d.double, align 8
store i32 2, i32* %d.type, align 4
br label %16

; <label>:13
%14 = getelementptr inbounds [1009 x i8]* %d.string, i32 0, i32 0
%15 = call i8* @strcpy(i8* %14, i8* %4)
store i32 3, i32* %d.type, align 4
br label %16

; <label>:16
%17 = load i8** %a.string, align 8
%18 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_string, i32 0, i32 0), i8* %17)
%19 = load i32* %b.int, align 4
%20 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_int, i32 0, i32 0), i32 %19)
%21 = load i32* %c.int, align 4
%22 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_int, i32 0, i32 0), i32 %21)
%23 = load i32* %d.type, align 4
%24 = icmp eq i32 %23, 1
br i1 %24, label %25, label %28

; <label>:25
%26 = load i32* %d.int, align 4
%27 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_int, i32 0, i32 0), i32 %26)
br label %36

; <label>:28
%29 = icmp eq i32 %23, 2
br i1 %29, label %30, label %33

; <label>:30
%31 = load double* %d.double, align 8
%32 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_double, i32 0, i32 0), double %31)
br label %36

; <label>:33
%34 = getelementptr inbounds [1009 x i8]* %d.string, i32 0, i32 0
%35 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_string, i32 0, i32 0), i8* %34)
br label %36

; <label>:36
ret i32 0
}

define zeroext i1 @IsDigital(i8* %ciagZnakow) nounwind {
%charEnd = alloca i8*, align 8
%1 = alloca i8*, align 8
store i8* %ciagZnakow, i8** %1, align 8
%2 = load i8** %1, align 8
%3 = call x86_fp80 @strtold(i8* %2, i8** %charEnd)
%4 = load i8** %charEnd, align 8
%5 = load i8* %4, align 1
%6 = sext i8 %5 to i32
%7 = icmp eq i32 %6, 0
ret i1 %7
}

define i8* @aa() nounwind {
%a.int = alloca i32, align 4
store i32 4, i32* %a.int, align 4
store i32 27, i32* %a.int, align 4
ret i8* getelementptr inbounds ([17 x i8]* @.aa.return, i32 0, i32 0)
}

declare i32 @scanf(i8*, ...)
declare x86_fp80 @strtold(i8*, i8**)
declare double @atof(i8*)
declare double @fmod(double, double)
declare i8* @strcpy(i8*, i8*)
declare i32 @printf(i8*, ...)

