const Page: React.FC<PageProps> = ({ children, style }) => {
  return (
    <>
      <div
        className={`${style} bg-purple tracking-wider font-comforta text-ivory min-h-screen`}
      >
        {children}
      </div>
    </>
  );
};

export default Page;

interface PageProps {
  children?: React.ReactNode;
  style?: string;
}
