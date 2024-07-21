const Section: React.FC<SectionProps> = ({
  title,
  content,
  style,
  listTitle,
  list,
  img,
  imgStyle,
}) => {
  return (
    <div
      className={`${style} flex flex-col items-center justify-center gap-6 p-6 w-full min-h-lvh`}
    >
      <h1 className="text-xl">{title}</h1>
      {img && <img src={img} className={`${imgStyle} w-96 h-auto my-10`} />}
      <p>{content}</p>
      {list && (
        <>
          <h2 className="font-extrabold text-5xl">{listTitle}</h2>
          <ul>
            {list.map((item, index) => (
              <li className="list-disc p-1 text-md" key={index}>
                {item}
              </li>
            ))}
          </ul>
        </>
      )}
    </div>
  );
};

export default Section;

interface SectionProps {
  img?: string;
  imgStyle?: string;
  title: string;
  content: string;
  style?: string;
  listTitle?: string;
  list?: string[];
}
