@.format_str1 = private unnamed_addr constant [5 x i8] c"%i \0A\00", align 1
@.format_str = private unnamed_addr constant [3 x i8] c"%i\00", align 1
define i32 @main() nounwind {
%b = alloca i32, align 4
store i32 25, i32* %b, align 4
%a = alloca i32, align 4
%1 = call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([3x i8]* @.format_str, i32 0, i32 0), i32* %a)
%2 = load i32* %a, align 4
%3 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.format_str1, i32 0, i32 0), i32 %2)
%4 = load i32* %b, align 4
%5 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.format_str1, i32 0, i32 0), i32 %4)
ret i32 0
}
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)

