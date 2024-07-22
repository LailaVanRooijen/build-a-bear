const Button: React.FC<ButtonProps> = ({
  content,
  handleClick,
  style,
  defaultColor,
}) => {
  const color = defaultColor
    ? "border-purple bg-purple text-maize hover:bg-maize hover:text-purple"
    : "border-maize bg-maize text-purple hover:bg-purple hover:text-maize";
  return (
    <div>
      <button
        className={`${style} ${color} m-4 border-2 p-4 rounded-lg font-extrabold tracking-wider`}
        onClick={handleClick}
      >
        {content}
      </button>
    </div>
  );
};

export default Button;

interface ButtonProps {
  content: string;
  handleClick?: () => void;
  style?: string;
  defaultColor?: boolean;
}
