const DisplayRow: React.FC<DisplayRowProps> = ({
  label,
  content,
  style,
  isDefaultStyle,
}) => {
  const colors = isDefaultStyle
    ? "bg-purple text-maize"
    : "bg-maize text-purple";
  return (
    <div
      className={`${style} ${colors} px-12 py-4 rounded-lg flex w-full justify-between`}
    >
      <p>{label}</p>
      <p>{content}</p>
    </div>
  );
};

export default DisplayRow;

interface DisplayRowProps {
  label: string;
  content: string;
  style?: string;
  isDefaultStyle?: boolean;
}
