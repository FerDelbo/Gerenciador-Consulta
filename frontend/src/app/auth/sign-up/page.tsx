import SignUp from "@/components/main/Register";
import AuthNav from "@/components/sub/nav/AuthNav";

export default function Page() {
  return (
    <>
      <AuthNav />
      <div className="mt-10">
        <SignUp />
      </div>
    </>
  );
}
